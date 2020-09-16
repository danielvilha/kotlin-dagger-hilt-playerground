package com.danielvilha.hilt_playerground.di

import android.content.Context
import androidx.room.Room
import com.danielvilha.hilt_playerground.business.data.cache.CacheDataSource
import com.danielvilha.hilt_playerground.business.data.cache.CacheDataSourceImpl
import com.danielvilha.hilt_playerground.business.domain.models.Blog
import com.danielvilha.hilt_playerground.business.domain.util.EntityMapper
import com.danielvilha.hilt_playerground.datasource.cache.BlogDaoService
import com.danielvilha.hilt_playerground.datasource.cache.BlogDaoServiceImpl
import com.danielvilha.hilt_playerground.datasource.cache.database.BlogDao
import com.danielvilha.hilt_playerground.datasource.cache.database.BlogDatabase
import com.danielvilha.hilt_playerground.datasource.cache.mappers.CacheMapper
import com.danielvilha.hilt_playerground.datasource.cache.model.BlogCacheEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
@Module
@InstallIn(ApplicationComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideCacheMapper(): EntityMapper<BlogCacheEntity, Blog> {
        return CacheMapper()
    }

    @Singleton
    @Provides
    fun provideBlogDb(@ApplicationContext context: Context): BlogDatabase {
        return Room
            .databaseBuilder(context, BlogDatabase::class.java, BlogDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBlogDAO(blogDatabase: BlogDatabase): BlogDao {
        return blogDatabase.blogDao()
    }

    @Singleton
    @Provides
    fun provideBlogDaoService(blogDao: BlogDao): BlogDaoService {
        return BlogDaoServiceImpl(blogDao)
    }

    @Singleton
    @Provides
    fun provideCacheDataSource(blogDaoService: BlogDaoService, cacheMapper: CacheMapper): CacheDataSource {
        return CacheDataSourceImpl(blogDaoService, cacheMapper)
    }
}