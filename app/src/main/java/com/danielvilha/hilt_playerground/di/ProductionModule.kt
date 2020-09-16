package com.danielvilha.hilt_playerground.di

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
object ProductionModule {
    @Singleton
    @Provides
    fun provideString(): String{
        return "This is a PRODUCTION string I'm providing for injection"
    }
}