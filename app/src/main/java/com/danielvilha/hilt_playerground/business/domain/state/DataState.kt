package com.danielvilha.hilt_playerground.business.domain.state

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}