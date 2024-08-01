package com.flxProviders.sudoflix.api.vidsrcto

import com.flixclusive.core.util.coroutines.asyncCalls
import com.flixclusive.core.util.network.asJsoup
import com.flixclusive.core.util.network.fromJson
import com.flixclusive.core.util.network.request
import com.flixclusive.model.provider.MediaLink
import com.flixclusive.model.provider.Subtitle
import com.flixclusive.model.tmdb.FilmDetails
import com.flixclusive.model.tmdb.common.tv.Episode
import com.flixclusive.provider.Provider
import com.flixclusive.provider.ProviderApi
import com.flixclusive.provider.extractor.Extractor
import com.flxProviders.sudoflix.api.vidsrcto.dto.EmbedSourcesResponse
import com.flxProviders.sudoflix.api.vidsrcto.dto.SourcesListResponse
import com.flxProviders.sudoflix.api.vidsrcto.extractor.Filemoon
import com.flxProviders.sudoflix.api.vidsrcto.util.VidSrcToDecryptionUtil.decodeUrl
import okhttp3.OkHttpClient

internal const val VIDSRCTO_KEY = "WXrUARXb1aDLaZjI"

internal class VidSrcToApi(
    client: OkHttpClient,
    provider: Provider
) : ProviderApi(client, provider) {
    private val name = "VidSrc.To"
    override val baseUrl = "https://vidsrc.to"

    private val extractors = mapOf(
        "filemoon" to Filemoon(client),
    )

    override suspend fun getLinks(
        watchId: String,
        film: FilmDetails,
        episode: Episode?
    ): List<MediaLink> {
        val actualWatchId = film.imdbId ?: film.tmdbId ?: watchId
        val episodeSlug = if (episode != null) "/${episode.season}/${episode.number}" else ""

        val dataId = client.request(
            url = "$baseUrl/embed/${film.filmType.type}/$actualWatchId$episodeSlug"
        ).execute()
            .asJsoup()
            .selectFirst("ul.episodes li a")
            ?.attr("data-id")
            ?: throw IllegalStateException("[$name]> Can't find data-id")

        val baseFilmUrl = "$baseUrl/ajax/embed/episode/$dataId"
        val sources = client.request(
            url = "$baseFilmUrl/sources"
        ).execute()
            .fromJson<SourcesListResponse>("[$name]> Can't parse sources")

        if (sources.status != 200 || sources.result.isEmpty()) {
            throw IllegalStateException("[$name]> Can't find sources")
        }

        val links = mutableListOf<MediaLink>()
        asyncCalls(
            {
                sources.result.forEach {
                    val extractor = extractors[it["title"]?.lowercase()]
                    if (extractor != null) {
                        val id = it["id"]
                            ?: throw IllegalStateException("[$name]> Can't find extractor id")

                        val extractedLinks = extractor.extractFromSources(id = id)
                        links.addAll(extractedLinks)
                    }
                }
            },
            {
                getSubtitles(
                    url = "$baseFilmUrl/subtitles",
                    onSubtitleLoaded = links::add
                )
            },
        )

        return links
    }

    private suspend fun Extractor.extractFromSources(id: String): List<MediaLink> {
        val response = client.request(
            url = "${this@VidSrcToApi.baseUrl}/ajax/embed/source/$id"
        ).execute()

        val embedData = response.fromJson<EmbedSourcesResponse>("[$name]> Can't parse embed data")

        if (embedData.status != 200) {
            throw IllegalStateException("[$name]> Error fetching embed sources")
        }

        val encryptedUrl = embedData.result["url"]
            ?: throw IllegalStateException("[$name]> Can't find encrypted url")
        val decryptedUrl = decodeUrl(encryptedUrl)

        return extract(url = decryptedUrl)
    }

    private fun getSubtitles(
        url: String,
        onSubtitleLoaded: (Subtitle) -> Unit
    ) {
        val subtitles = client.request(url = url).execute()
            .fromJson<List<Map<String, String>>>()

        subtitles.forEach {
            val file = it["file"]
            val label = it["label"]

            if (file != null) {
                onSubtitleLoaded(
                    Subtitle(
                        url = file,
                        language = label ?: "UNKNOWN LANG"
                    )
                )
            }
        }
    }
}