package com.dotech.erakulistest.presentation.ui.image_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dotech.erakulistest.data.models.ImageDTO
import com.dotech.erakulistest.data.models.Resource
import com.dotech.erakulistest.domain.use_cases.GetImageDetailsUseCase
import com.dotech.erakulistest.presentation.common.Constrains.PARAM_IMG_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ImageDetailViewModel @Inject constructor(
    private val getImageUseCase: GetImageDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val _state = mutableStateOf(ImageDetailsState())
    val state : State<ImageDetailsState> = _state

    private fun getImage(imgId: String) {
        getImageUseCase(imgId).onEach { result ->
            when (result) {
                is Resource.Success -> _state.value =
                    ImageDetailsState(image = result.data)

                is Resource.Error -> _state.value =
                    ImageDetailsState(error = result.message ?: "unExpected Error VM")

                is Resource.Loading -> _state.value = ImageDetailsState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }

    init {
        savedStateHandle.get<String>(PARAM_IMG_ID)?.let {id->
            getImage(id)
        }
    }

}