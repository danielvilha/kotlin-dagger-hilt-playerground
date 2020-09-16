package com.danielvilha.hilt_playerground.di

import androidx.fragment.app.FragmentFactory
import com.danielvilha.hilt_playerground.business.domain.models.Blog
import com.danielvilha.hilt_playerground.ui.main.MainFragmentFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
@ExperimentalCoroutinesApi
@Module
@InstallIn(ApplicationComponent::class)
object FragmentModule {

    @Singleton
    @Provides
    fun provideFactory(str: String): FragmentFactory {
        return MainFragmentFactory(str)
    }
}