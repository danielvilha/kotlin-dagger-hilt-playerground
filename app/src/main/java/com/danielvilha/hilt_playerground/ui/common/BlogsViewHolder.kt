package com.danielvilha.hilt_playerground.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danielvilha.hilt_playerground.R
import com.danielvilha.hilt_playerground.business.domain.models.Blog
import com.squareup.picasso.Picasso

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
class BlogsViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_blog, parent, false)) {
    var image: ImageView? = null
    var title: TextView? = null
    var body: TextView? = null

    init {
        image = itemView.findViewById(R.id.image)
        title = itemView.findViewById(R.id.title)
        body = itemView.findViewById(R.id.body)
    }

    fun bind(blog: Blog) {
        Picasso.get().load(blog.image).into(image)
        title?.text = blog.title
        body?.text = blog.body
    }
}