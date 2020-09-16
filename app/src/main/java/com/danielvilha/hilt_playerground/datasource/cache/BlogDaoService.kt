package com.danielvilha.hilt_playerground.datasource.cache

import com.danielvilha.hilt_playerground.datasource.cache.model.BlogCacheEntity

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
interface BlogDaoService {
    suspend fun insert(blogEntity: BlogCacheEntity): Long

    suspend fun get(): List<BlogCacheEntity>
}