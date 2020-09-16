package com.danielvilha.hilt_playerground.datasource.network

import com.danielvilha.hilt_playerground.datasource.network.model.BlogNetworkEntity

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
interface BlogRetrofitService {
    suspend fun get(): List<BlogNetworkEntity>
}