package com.danielvilha.hilt_playerground.business.interactors

import com.danielvilha.hilt_playerground.business.data.cache.CacheDataSource
import com.danielvilha.hilt_playerground.business.data.network.NetworkDataSource
import com.danielvilha.hilt_playerground.business.domain.models.Blog
import com.danielvilha.hilt_playerground.business.domain.state.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
class GetBlogs constructor(private val cacheDataSource: CacheDataSource, private val networkDataSource: NetworkDataSource) {

    /**
     * Show loading
     * Get blogs from network
     * Insert blogs into cache
     * Show List<Blog>
     */
    suspend fun execute(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        val networkBlogs = networkDataSource.get()
        cacheDataSource.insertList(networkBlogs)
        val cachedBlogs = cacheDataSource.get()
        emit(DataState.Success(cachedBlogs))
    }
}