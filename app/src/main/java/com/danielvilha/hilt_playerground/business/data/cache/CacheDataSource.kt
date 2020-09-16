package com.danielvilha.hilt_playerground.business.data.cache

import com.danielvilha.hilt_playerground.business.domain.models.Blog

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
interface CacheDataSource {
    suspend fun insert(blog: Blog): Long

    suspend fun insertList(blogs: List<Blog>)

    suspend fun get(): List<Blog>
}