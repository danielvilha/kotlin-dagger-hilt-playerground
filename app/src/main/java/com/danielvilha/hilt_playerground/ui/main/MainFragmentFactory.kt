package com.danielvilha.hilt_playerground.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.danielvilha.hilt_playerground.business.domain.models.Blog
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
@ExperimentalCoroutinesApi
class MainFragmentFactory @Inject constructor(private val str: String): FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            MainFragment::class.java.name -> {
                val fragment = MainFragment(str)
                fragment
            }

            else -> super.instantiate(classLoader, className)
        }
    }
}