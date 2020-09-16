package com.danielvilha.hilt_playerground.business.data.network

import com.danielvilha.hilt_playerground.business.domain.models.Blog

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
interface NetworkDataSource {
    suspend fun get(): List<Blog>
}