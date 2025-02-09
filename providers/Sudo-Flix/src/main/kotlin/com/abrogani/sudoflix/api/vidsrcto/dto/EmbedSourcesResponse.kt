package com.abrogani.sudoflix.api.vidsrcto.dto

internal data class EmbedSourcesResponse(
    val status: Int,
    val result: Map<String, String>
)