package com.danielvilha.hilt_playerground.datasource.network

import com.danielvilha.hilt_playerground.datasource.network.model.BlogNetworkEntity
import com.danielvilha.hilt_playerground.datasource.network.service.BlogService

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
class BlogRetrofitServiceImpl constructor(private val service: BlogService): BlogRetrofitService {
    override suspend fun get(): List<BlogNetworkEntity> {
        return service.get()
    }
}