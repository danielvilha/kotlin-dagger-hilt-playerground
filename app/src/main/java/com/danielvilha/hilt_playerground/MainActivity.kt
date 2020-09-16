package com.danielvilha.hilt_playerground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danielvilha.hilt_playerground.ui.main.MainFragmentFactory
import com.danielvilha.hilt_playerground.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.fragmentFactory = fragmentFactory
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, MainFragment::class.java, null)
            .commit()
    }
}