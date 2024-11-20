package com.dotech.erakulistest.presentation.ui.home

import com.dotech.erakulistest.domain.models.Image


data class HomeScreenState(
    val isLoading: Boolean = false,
    val images: List<Image> = emptyList(),
    val error: String = ""
)
