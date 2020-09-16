package com.danielvilha.hilt_playerground.di

import com.danielvilha.hilt_playerground.business.data.network.NetworkDataSource
import com.danielvilha.hilt_playerground.business.data.network.NetworkDataSourceImpl
import com.danielvilha.hilt_playerground.business.domain.models.Blog
import com.danielvilha.hilt_playerground.business.domain.util.EntityMapper
import com.danielvilha.hilt_playerground.datasource.network.BlogRetrofitService
import com.danielvilha.hilt_playerground.datasource.network.BlogRetrofitServiceImpl
import com.danielvilha.hilt_playerground.datasource.network.mappers.NetworkMapper
import com.danielvilha.hilt_playerground.datasource.network.model.BlogNetworkEntity
import com.danielvilha.hilt_playerground.datasource.network.service.BlogService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideNetworkMapper(): EntityMapper<BlogNetworkEntity, Blog> {
        return NetworkMapper()
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://open-api.xyz/placeholder/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideBlogService(builder: Retrofit.Builder): BlogService {
        return builder
            .build()
            .create(BlogService::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofitService(service: BlogService): BlogRetrofitService{
        return BlogRetrofitServiceImpl(service)
    }

    @Singleton
    @Provides
    fun provideNetworkDataSource(blogRetrofitService: BlogRetrofitService, networkMapper: NetworkMapper): NetworkDataSource {
        return NetworkDataSourceImpl(blogRetrofitService, networkMapper)
    }
}