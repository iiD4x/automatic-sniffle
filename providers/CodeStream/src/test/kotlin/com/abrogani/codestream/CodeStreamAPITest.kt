package com.abrogani.codestream

import android.util.Base64
import com.flixclusive.core.util.log.LogRule
import com.flixclusive.model.provider.link.MediaLink
import com.flixclusive.provider.ProviderApi
import io.mockk.every
import io.mockk.mockkStatic
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class CodeStreamAPITest {
    private lateinit var api: ProviderApi

    @get:Rule
    val rule = LogRule()

    @Before
    fun setUp() {
        mockkStatic(Base64::class)
        every { Base64.decode(any(ByteArray::class), any()) } answers {
            java.util.Base64.getDecoder().decode(args[0] as ByteArray)
        }
        every { Base64.encodeToString(any(ByteArray::class), any()) } answers {
            java.util.Base64.getEncoder().encodeToString(args[0] as ByteArray)
        }

        api = CodeStreamAPI(
            client = OkHttpClient(),
            provider = CodeStreamFlixclusive()
        )
    }

    @Test
    fun getLinks() = runTest {
        val testMovie = api.testFilm

        val links = mutableListOf<MediaLink>()
        api.getLinks(
            testMovie.identifier,
            testMovie,
            null,
            links::add
        )

        assert(links.isNotEmpty())
    }
}