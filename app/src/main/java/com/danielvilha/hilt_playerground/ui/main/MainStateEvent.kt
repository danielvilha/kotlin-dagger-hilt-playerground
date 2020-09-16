package com.danielvilha.hilt_playerground.ui.main

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
sealed class MainStateEvent {
    object GetBlogsEvent: MainStateEvent()

    object None: MainStateEvent()
}