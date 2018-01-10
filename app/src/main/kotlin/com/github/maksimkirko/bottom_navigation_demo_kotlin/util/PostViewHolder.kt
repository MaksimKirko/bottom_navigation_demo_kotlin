package com.github.maksimkirko.bottom_navigation_demo_kotlin.util

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.github.maksimkirko.bottom_navigation_demo_kotlin.R

class PostViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    private lateinit var textView: TextView

    fun onBind(text: String) {
        textView!!.text = text
    }

    init {
        if (itemView != null) {
            this.textView = itemView.findViewById(R.id.text_view_view_holder_post)
        }
    }
}
