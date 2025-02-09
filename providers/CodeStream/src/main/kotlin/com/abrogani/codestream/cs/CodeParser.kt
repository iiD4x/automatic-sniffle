package com.abrogani.codestream.cs

// import com.fasterxml.jackson.annotation.JsonProperty
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

data class CrunchyrollAccessToken(
    val accessToken: String? = null,
    val tokenType: String? = null,
    val bucket: String? = null,
    val policy: String? = null,
    val signature: String? = null,
    val key_pair_id: String? = null,
)

data class FDMovieIFrame(
    val link: String,
    val quality: String,
    val size: String,
    val type: String,
)

data class AniIds(var id: Int? = null, var idMal: Int? = null)

data class TmdbDate(
    val today: String,
    val nextWeek: String,
)

data class AniwaveResponse(
    val result: String
) {
    fun asJsoup(): Document {
        return Jsoup.parse(result)
    }
}

data class AniwaveServer(
    val result: Result
) {
    data class Result(
        val url: String
    ) {
        fun decrypt(): String {
            return AniwaveUtils.vrfDecrypt(url)
        }
    }
}

data class MoflixResponse(
    val title: Episode? = null,
    val episode: Episode? = null,
) {
    data class Episode(
        val id: Int? = null,
        val videos: ArrayList<Videos>? = arrayListOf(),
    ) {
        data class Videos(
            val name: String? = null,
            val category: String? = null,
            val src: String? = null,
            val quality: String? = null,
        )
    }
}

data class AniMedia(
    var id: Int? = null,
    var idMal: Int? = null
)

data class AniPage(var media: java.util.ArrayList<AniMedia> = arrayListOf())

data class AniData(var Page: AniPage? = AniPage())

data class AniSearch(var data: AniData? = AniData())

data class GpressSources(
    val src: String,
    val file: String? = null,
    val label: Int? = null,
    val max: String,
)

//AsianHDResponse
data class AsianHDResponse(
    val data: Data
)

data class Data(
    val links: List<Link>
)

data class Link(
    val type: String,
    val url: String
)
//

//Dramacool


data class StreamwishD(
    val server: String,
    val link: String,
    val active: Long,
)

data class Backup(
    val server: String,
    val link: String,
)


data class KissasianAPISourceresponse(
    val type: String,
    val link: String? = null,
)

data class KissasianAPIResponse(
    val status: Boolean,
    val html: String
)

data class UHDBackupUrl(
    val url: String? = null,
)

data class ResponseHash(
    val embed_url: String,
    val key: String? = null,
    val type: String? = null,
)

data class KisskhSources(
    val video: String?,
    val thirdParty: String?,
)

data class KisskhSubtitle(
    val src: String?,
    val label: String?,
)

data class KisskhEpisodes(
    val id: Int?,
    val number: Int?,
)

data class KisskhDetail(
    val episodes: ArrayList<KisskhEpisodes>? = arrayListOf(),
)

data class KisskhResults(
    val id: Int?,
    val title: String?,
)

data class DriveBotLink(
    val url: String? = null,
)

data class DirectDl(
    val download_url: String? = null,
)

data class Safelink(
    val safelink: String? = null,
)

data class FDAds(
    val linkr: String? = null,
)

data class ZShowEmbed(
    val meta: String? = null,
)

data class WatchsomuchTorrents(
    val id: Int? = null,
    val movieId: Int? = null,
    val season: Int? = null,
    val episode: Int? = null,
)

data class WatchsomuchMovies(
    val torrents: ArrayList<WatchsomuchTorrents>? = arrayListOf(),
)

data class WatchsomuchResponses(
    val movie: WatchsomuchMovies? = null,
)

data class WatchsomuchSubtitles(
    val url: String? = null,
    val label: String? = null,
)

data class WatchsomuchSubResponses(
    val subtitles: ArrayList<WatchsomuchSubtitles>? = arrayListOf(),
)

data class IndexMedia(
    val id: String? = null,
    val driveId: String? = null,
    val mimeType: String? = null,
    val size: String? = null,
    val name: String? = null,
    val modifiedTime: String? = null,
)

data class IndexData(
    val files: ArrayList<IndexMedia>? = arrayListOf(),
)

data class IndexSearch(
    val data: IndexData? = null,
)

data class JikanExternal(
    val name: String? = null,
    val url: String? = null,
)

data class JikanData(
    val title: String? = null,
    val external: ArrayList<JikanExternal>? = arrayListOf(),
)

data class JikanResponse(
    val data: JikanData? = null,
)

data class VidsrctoResult(
    val id: String? = null,
    val title: String? = null,
    val url: String? = null,
)

data class VidsrctoResponse(
    val result: VidsrctoResult? = null,
)

data class VidsrctoSources(
    val result: ArrayList<VidsrctoResult>? = arrayListOf(),
)

data class VidsrctoSubtitles(
    val label: String? = null,
    val file: String? = null,
)


data class SmashyRoot(
    val data: SmashyData,
    val success: Boolean,
)

data class SmashyData(
    val sources: List<Source>,
    val tracks: String,
)

data class Source(
    val file: String,
)


data class AnilistExternalLinks(
    var id: Int? = null,
    var site: String? = null,
    var url: String? = null,
    var type: String? = null,
)

data class AnilistMedia(var externalLinks: ArrayList<AnilistExternalLinks> = arrayListOf())

data class AnilistData(var Media: AnilistMedia? = AnilistMedia())

data class AnilistResponses(var data: AnilistData? = AnilistData())

data class CrunchyrollToken(
    val accessToken: String? = null,
    val tokenType: String? = null,
    val cms: Cms? = null,
) {
    data class Cms(
        var bucket: String? = null,
        var policy: String? = null,
        var signature: String? = null,
        var key_pair_id: String? = null,
    )
}

data class CrunchyrollVersions(
    val audio_locale: String? = null,
    val guid: String? = null,
)

data class CrunchyrollData(
    val id: String? = null,
    val title: String? = null,
    val slug_title: String? = null,
    val season_number: Int? = null,
    val episode_number: Int? = null,
    val versions: ArrayList<CrunchyrollVersions>? = null,
    val streams_link: String? = null,
)

data class CrunchyrollResponses(
    val data: ArrayList<CrunchyrollData>? = arrayListOf(),
)

data class CrunchyrollSourcesResponses(
    val streams: Streams? = Streams(),
    val subtitles: HashMap<String, HashMap<String, String>>? = hashMapOf(),
) {
    data class Streams(
        val adaptive_hls: HashMap<String, HashMap<String, String>>? = hashMapOf(),
        val vo_adaptive_hls: HashMap<String, HashMap<String, String>>? = hashMapOf(),
    )
}

data class MALSyncSites(
    val zoro: HashMap<String?, HashMap<String, String?>>? = hashMapOf(),
    val nineAnime: HashMap<String?, HashMap<String, String?>>? = hashMapOf(),
)

data class MALSyncResponses(
    val sites: MALSyncSites? = null,
)

data class HianimeResponses(
    val html: String? = null,
    val link: String? = null,
)

data class MalSyncRes(
    val Sites: Map<String, Map<String, Map<String, String>>>? = null,
)

data class GokuData(
    val link: String? = null,
)

data class GokuServer(
    val data: GokuData? = GokuData(),
)

data class AllMovielandEpisodeFolder(
    val title: String? = null,
    val id: String? = null,
    val file: String? = null,
)

data class AllMovielandSeasonFolder(
    val episode: String? = null,
    val id: String? = null,
    val folder: ArrayList<AllMovielandEpisodeFolder>? = arrayListOf(),
)

data class AllMovielandServer(
    val title: String? = null,
    val id: String? = null,
    val file: String? = null,
    val folder: ArrayList<AllMovielandSeasonFolder>? = arrayListOf(),
)

data class AllMovielandPlaylist(
    val file: String? = null,
    val key: String? = null,
    val href: String? = null,
)

data class DumpMedia(
    val id: String? = null,
    val domainType: Int? = null,
    val name: String? = null,
    val releaseTime: String? = null,
)

data class DumpQuickSearchData(
    val searchResults: ArrayList<DumpMedia>? = arrayListOf(),
)

data class SubtitlingList(
    val languageAbbr: String? = null,
    val language: String? = null,
    val subtitlingUrl: String? = null,
)

data class DefinitionList(
    val code: String? = null,
    val description: String? = null,
)

data class EpisodeVo(
    val id: Int? = null,
    val seriesNo: Int? = null,
    val definitionList: ArrayList<DefinitionList>? = arrayListOf(),
    val subtitlingList: ArrayList<SubtitlingList>? = arrayListOf(),
)

data class DumpMediaDetail(
    val episodeVo: ArrayList<EpisodeVo>? = arrayListOf(),
)

data class EMovieServer(
    val value: String? = null,
)

data class EMovieSources(
    val file: String? = null,
)

data class EMovieTraks(
    val file: String? = null,
    val label: String? = null,
)

data class ShowflixResultsMovies(
    val movieName: String? = null,
    val streamwish: String? = null,
    val filelions: String? = null,
    val streamruby: String? = null,
)

data class ShowflixResultsSeries(
    val seriesName: String? = null,
    val streamwish: HashMap<String, List<String>>? = hashMapOf(),
    val filelions: HashMap<String, List<String>>? = hashMapOf(),
    val streamruby: HashMap<String, List<String>>? = hashMapOf(),
)

data class ShowflixSearchMovies(
    val resultsMovies: ArrayList<ShowflixResultsMovies>? = arrayListOf(),
)

data class ShowflixSearchSeries(
    val resultsSeries: ArrayList<ShowflixResultsSeries>? = arrayListOf(),
)

data class SFMoviesSeriess(
    var title: String? = null,
    var svideos: String? = null,
)

data class SFMoviesAttributes(
    var title: String? = null,
    var video: String? = null,
    var releaseDate: String? = null,
    var seriess: ArrayList<ArrayList<SFMoviesSeriess>>? = arrayListOf(),
    var contentId: String? = null,
)

data class SFMoviesData(
    var id: Int? = null,
    var attributes: SFMoviesAttributes? = SFMoviesAttributes()
)

data class SFMoviesSearch(
    var data: ArrayList<SFMoviesData>? = arrayListOf(),
)

data class RidoContentable(
    var imdbId: String? = null,
    var tmdbId: Int? = null,
)

data class RidoItems(
    var slug: String? = null,
    var contentable: RidoContentable? = null,
)

data class RidoData(
    var url: String? = null,
    var items: ArrayList<RidoItems>? = arrayListOf(),
)

data class RidoResponses(
    var data: ArrayList<RidoData>? = arrayListOf(),
)

data class RidoSearch(
    var data: RidoData? = null,
)

data class SmashySources(
    var sourceUrls: ArrayList<String>? = arrayListOf(),
    var subtitleUrls: String? = null,
)

data class AoneroomResponse(
    val data: Data? = null,
) {
    data class Data(
        val items: ArrayList<Items>? = arrayListOf(),
        val list: ArrayList<List>? = arrayListOf(),
    ) {
        data class Items(
            val subjectId: String? = null,
            val title: String? = null,
            val releaseDate: String? = null,
        )

        data class List(
            val resourceLink: String? = null,
            val extCaptions: ArrayList<ExtCaptions>? = arrayListOf(),
            val se: Int? = null,
            val ep: Int? = null,
            val resolution: Int? = null,
        ) {
            data class ExtCaptions(
                val lanName: String? = null,
                val url: String? = null,
            )
        }
    }
}

data class CinemaTvResponse(
    val streams: HashMap<String, String>? = null,
    val subtitles: ArrayList<Subtitles>? = arrayListOf(),
) {
    data class Subtitles(
        val language: String? = null,
        val file: Any? = null,
    )
}

data class NepuSearch(
    val data: ArrayList<Data>? = arrayListOf(),
) {
    data class Data(
        val url: String? = null,
        val name: String? = null,
        val type: String? = null,
    )
}

data class Bollyflixparse(
    val url: String,
)