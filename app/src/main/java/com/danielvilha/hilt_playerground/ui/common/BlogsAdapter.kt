package com.danielvilha.hilt_playerground.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danielvilha.hilt_playerground.business.domain.models.Blog

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
class BlogsAdapter(private val list: List<Blog>): RecyclerView.Adapter<BlogsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return BlogsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: BlogsViewHolder, position: Int) {
        val blog: Blog = list[position]
        holder.bind(blog)
    }

    override fun getItemCount(): Int = list.size
}