package com.github.maksimkirko.bottom_navigation_demo_kotlin.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.maksimkirko.bottom_navigation_demo_kotlin.R

class RecyclerViewAdapter : RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_post, parent, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.onBind("Item " + position)
    }

    override fun getItemCount(): Int {
        return 50
    }
}
