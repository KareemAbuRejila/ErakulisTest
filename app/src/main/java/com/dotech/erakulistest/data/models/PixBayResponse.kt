package com.dotech.erakulistest.data.models

data class PixBayResponse(
    val hits: List<ImageDTO>,
    val total: Int,
    val totalHits: Int
)