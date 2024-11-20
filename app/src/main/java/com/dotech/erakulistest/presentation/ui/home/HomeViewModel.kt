package com.dotech.erakulistest.presentation.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dotech.erakulistest.data.models.Resource
import com.dotech.erakulistest.domain.use_cases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getImagesUseCase: GetCoinsUseCase,

) : ViewModel() {

    private val _state = mutableStateOf(HomeScreenState())
    val state: State<HomeScreenState> = _state


    init {
        // Fetch countries only if they haven't been loaded yet
        fetchImages()
    }

    fun fetchImages() {
        getImagesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> _state.value =
                    HomeScreenState(images = result.data ?: emptyList())

                is Resource.Loading -> _state.value =
                    HomeScreenState(isLoading = true)

                is Resource.Error -> _state.value =
                    HomeScreenState(error = result.message ?: "unExpected Error VM")
            }
        }.launchIn(viewModelScope)
    }
    fun logout(){

    }

}