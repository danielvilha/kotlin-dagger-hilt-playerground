package com.danielvilha.hilt_playerground.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.danielvilha.hilt_playerground.R
import com.danielvilha.hilt_playerground.business.domain.models.Blog
import com.danielvilha.hilt_playerground.business.domain.state.DataState
import com.danielvilha.hilt_playerground.ui.common.BlogsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

import kotlinx.android.synthetic.main.fragment_main.*

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment constructor(private val str: String): Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetBlogsEvent)
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when(dataState){
                is DataState.Success<List<Blog>> -> {
                    displayProgressBar(false)
                    appendBlogs(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }


    private fun displayError(message: String?) {
        if (message != null) this.message.text = message else this.message.text = getString(R.string.error)
    }

    private fun appendBlogs(blogs: List<Blog>) {
        recycler.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = BlogsAdapter(blogs)
        }
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        progress_bar.visibility = if(isDisplayed) View.VISIBLE else View.GONE
    }
}