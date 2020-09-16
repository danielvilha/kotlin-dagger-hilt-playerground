package com.danielvilha.hilt_playerground.datasource.network.service

import com.danielvilha.hilt_playerground.datasource.network.model.BlogNetworkEntity
import retrofit2.http.GET

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
interface BlogService {

    @GET("blogs")
    suspend fun get(): List<BlogNetworkEntity>
}