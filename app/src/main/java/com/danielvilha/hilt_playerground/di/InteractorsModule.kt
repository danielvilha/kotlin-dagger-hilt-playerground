package com.danielvilha.hilt_playerground.di

import com.danielvilha.hilt_playerground.business.data.cache.CacheDataSource
import com.danielvilha.hilt_playerground.business.data.network.NetworkDataSource
import com.danielvilha.hilt_playerground.business.interactors.GetBlogs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
@Module
@InstallIn(ApplicationComponent::class)
object InteractorsModule {
    @Singleton
    @Provides
    fun provideGetBlogs(cacheDataSource: CacheDataSource, networkDataSource: NetworkDataSource): GetBlogs{
        return GetBlogs(cacheDataSource, networkDataSource)
    }
}