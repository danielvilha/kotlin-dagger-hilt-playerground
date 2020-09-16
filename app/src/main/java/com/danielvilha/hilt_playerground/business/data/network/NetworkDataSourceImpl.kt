package com.danielvilha.hilt_playerground.business.data.network

import com.danielvilha.hilt_playerground.business.domain.models.Blog
import com.danielvilha.hilt_playerground.datasource.network.BlogRetrofitService
import com.danielvilha.hilt_playerground.datasource.network.mappers.NetworkMapper

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
class NetworkDataSourceImpl constructor(private val blogRetrofitService: BlogRetrofitService, private val networkMapper: NetworkMapper): NetworkDataSource {
    override suspend fun get(): List<Blog> {
        return networkMapper.mapFromEntityList(blogRetrofitService.get())
    }
}