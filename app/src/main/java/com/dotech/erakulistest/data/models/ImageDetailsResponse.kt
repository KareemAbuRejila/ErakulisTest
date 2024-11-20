package com.dotech.erakulistest.data.models

data class ImageDetailsResponse(
    val imageDetailsList: List<ImageDetails>,
    val total: Int,
    val totalHits: Int
)