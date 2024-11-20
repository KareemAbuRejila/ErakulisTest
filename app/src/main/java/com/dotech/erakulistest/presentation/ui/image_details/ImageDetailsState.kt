package com.dotech.erakulistest.presentation.ui.image_details

import com.dotech.erakulistest.data.models.ImageDTO

data class ImageDetailsState(
    val isLoading: Boolean = false,
    val image: ImageDTO ?= null,
    val error: String = ""
)
