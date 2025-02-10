package com.abrogani.codestream

import android.content.Context
import com.flixclusive.provider.FlixclusiveProvider
import com.flixclusive.provider.Provider
import com.lagradost.cloudstream3.extractors.DoodYtExtractor
import com.lagradost.cloudstream3.extractors.FileMoon
import com.lagradost.cloudstream3.extractors.Gofile
import com.lagradost.cloudstream3.extractors.MixDrop
import com.lagradost.cloudstream3.extractors.Moviesapi
import com.lagradost.cloudstream3.extractors.Mp4Upload
import com.lagradost.cloudstream3.extractors.StreamTape
import com.lagradost.cloudstream3.extractors.StreamWishExtractor
import com.lagradost.cloudstream3.extractors.VidHidePro6
import com.lagradost.cloudstream3.extractors.VidSrcExtractor
import com.lagradost.cloudstream3.extractors.Vidmolyme
import com.lagradost.cloudstream3.extractors.Vidplay
import com.lagradost.cloudstream3.extractors.Voe
import com.lagradost.cloudstream3.utils.ExtractorApi
import com.lagradost.cloudstream3.utils.extractorApis
import okhttp3.OkHttpClient

internal const val CODE_STREAM_NAME = "CodeStream"

@FlixclusiveProvider
class CodeStreamFlixclusive : Provider() {
    override val name: String get() = CODE_STREAM_NAME

    override fun getApi(
        context: Context,
        client: OkHttpClient,
    ) = CodeStreamAPI(
        client = client,
        provider = this,
    )

    fun registerExtractor(extractor: ExtractorApi) {
        extractorApis.add(extractor)
    }

    init {
        registerExtractor(com.abrogani.codestream.cs.Animefever())
        registerExtractor(com.abrogani.codestream.cs.Multimovies())
        registerExtractor(com.abrogani.codestream.cs.MultimoviesSB())
        registerExtractor(com.abrogani.codestream.cs.Yipsu())
        registerExtractor(com.abrogani.codestream.cs.Mwish())
        registerExtractor(com.abrogani.codestream.cs.TravelR())
        registerExtractor(com.abrogani.codestream.cs.Playm4u())
        registerExtractor(Vidplay())
        registerExtractor(FileMoon())
        registerExtractor(com.abrogani.codestream.cs.VCloud())
        registerExtractor(com.abrogani.codestream.cs.Bestx())
        registerExtractor(com.abrogani.codestream.cs.Filelions())
        registerExtractor(com.abrogani.codestream.cs.Snolaxstream())
        registerExtractor(com.abrogani.codestream.cs.Pixeldra())
        registerExtractor(Mp4Upload())
        registerExtractor(com.abrogani.codestream.cs.Graceaddresscommunity())
        registerExtractor(com.abrogani.codestream.cs.M4ufree())
        registerExtractor(com.abrogani.codestream.cs.Streamruby())
        registerExtractor(StreamWishExtractor())
        registerExtractor(com.abrogani.codestream.cs.Filelion())
        registerExtractor(DoodYtExtractor())
        registerExtractor(com.abrogani.codestream.cs.dlions())
        registerExtractor(MixDrop())
        registerExtractor(com.abrogani.codestream.cs.dwish())
        registerExtractor(com.abrogani.codestream.cs.Embedwish())
        registerExtractor(com.abrogani.codestream.cs.UqloadsXyz())
        registerExtractor(com.abrogani.codestream.cs.Uploadever())
        registerExtractor(com.abrogani.codestream.cs.Netembed())
        registerExtractor(com.abrogani.codestream.cs.Flaswish())
        registerExtractor(com.abrogani.codestream.cs.Comedyshow())
        registerExtractor(com.abrogani.codestream.cs.Ridoo())
        registerExtractor(com.abrogani.codestream.cs.Streamvid())
        registerExtractor(StreamTape())
        registerExtractor(com.abrogani.codestream.cs.do0od())
        registerExtractor(com.abrogani.codestream.cs.Embedrise())
        registerExtractor(com.abrogani.codestream.cs.Gdmirrorbot())
        registerExtractor(com.abrogani.codestream.cs.FilemoonNl())
        registerExtractor(com.abrogani.codestream.cs.Alions())
        registerExtractor(Vidmolyme())
        registerExtractor(com.abrogani.codestream.cs.AllinoneDownloader())
        registerExtractor(com.abrogani.codestream.cs.Tellygossips())
        registerExtractor(com.abrogani.codestream.cs.Tvlogy())
        registerExtractor(Voe())
        registerExtractor(com.abrogani.codestream.cs.Mdrive())
        registerExtractor(Gofile())
        registerExtractor(com.abrogani.codestream.cs.Animezia())
        registerExtractor(Moviesapi())
        registerExtractor(com.abrogani.codestream.cs.PixelDrain())
        registerExtractor(com.abrogani.codestream.cs.Modflix())
        registerExtractor(com.abrogani.codestream.cs.Vectorx())
        registerExtractor(com.abrogani.codestream.cs.Sethniceletter())
        registerExtractor(com.abrogani.codestream.cs.GDFlix())
        registerExtractor(com.abrogani.codestream.cs.fastdlserver())
        registerExtractor(com.abrogani.codestream.cs.Asianbxkiun())
        registerExtractor(com.abrogani.codestream.cs.GDFlix1())
        registerExtractor(com.abrogani.codestream.cs.GDFlix2())
        registerExtractor(com.abrogani.codestream.cs.furher())
        registerExtractor(VidSrcExtractor())
        registerExtractor(com.abrogani.codestream.cs.Servertwo())
        registerExtractor(com.abrogani.codestream.cs.MultimoviesAIO())
        registerExtractor(com.abrogani.codestream.cs.HubCloud())
        registerExtractor(com.abrogani.codestream.cs.HubCloudClub())
        registerExtractor(com.abrogani.codestream.cs.HubCloudlol())
        registerExtractor(com.abrogani.codestream.cs.Driveseed())
        registerExtractor(com.abrogani.codestream.cs.Driveleech())
        registerExtractor(VidHidePro6())
        registerExtractor(com.abrogani.codestream.cs.MixDropSi())
        registerExtractor(Mp4Upload())
    }
}
