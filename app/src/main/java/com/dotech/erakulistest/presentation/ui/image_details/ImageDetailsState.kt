package com.dotech.erakulistest.presentation.ui.image_details

import com.dotech.erakulistest.data.models.ImageDTO
import com.dotech.erakulistest.data.models.ImageDetails

data class ImageDetailsState(
    val isLoading: Boolean = false,
    val image: ImageDetails ?= null,
    val error: String = ""
)
