package com.danielvilha.hilt_playerground.datasource.cache

import com.danielvilha.hilt_playerground.datasource.cache.database.BlogDao
import com.danielvilha.hilt_playerground.datasource.cache.model.BlogCacheEntity

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
class BlogDaoServiceImpl constructor(private val blogDao: BlogDao): BlogDaoService {
    override suspend fun insert(blogEntity: BlogCacheEntity): Long {
        return blogDao.insert(blogEntity)
    }

    override suspend fun get(): List<BlogCacheEntity> {
        return blogDao.get()
    }
}