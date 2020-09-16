package com.danielvilha.hilt_playerground.business.data.cache

import com.danielvilha.hilt_playerground.business.domain.models.Blog
import com.danielvilha.hilt_playerground.datasource.cache.BlogDaoService
import com.danielvilha.hilt_playerground.datasource.cache.mappers.CacheMapper

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
class CacheDataSourceImpl constructor(private val blogDaoService: BlogDaoService, private val cacheMapper: CacheMapper): CacheDataSource {
    override suspend fun insert(blog: Blog): Long {
        return blogDaoService.insert(cacheMapper.mapToEntity(blog))
    }

    override suspend fun insertList(blogs: List<Blog>){
        for(blog in blogs) {
            blogDaoService.insert(cacheMapper.mapToEntity(blog))
        }
    }

    override suspend fun get(): List<Blog> {
        return cacheMapper.mapFromEntityList(blogDaoService.get())
    }
}