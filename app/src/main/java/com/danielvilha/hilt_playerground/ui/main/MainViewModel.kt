package com.danielvilha.hilt_playerground.ui.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.danielvilha.hilt_playerground.business.domain.models.Blog
import com.danielvilha.hilt_playerground.business.domain.state.DataState
import com.danielvilha.hilt_playerground.business.interactors.GetBlogs
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.lang.Error

@ExperimentalCoroutinesApi
class MainViewModel @ViewModelInject constructor(private val getBlogs: GetBlogs, @Assisted private val savedStateHandle: SavedStateHandle): ViewModel() {
    private val _dataState: MutableLiveData<DataState<List<Blog>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Blog>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetBlogsEvent -> {
                    getBlogs.execute()
                        .onEach {dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                is MainStateEvent.None -> {
                    getBlogs.execute()
                        .onEach {
                            savedStateHandle.getLiveData<Error>(MainStateEvent.None.toString())
                        }
                }
            }
        }
    }
}