package com.github.maksimkirko.bottom_navigation_demo_kotlin.fragment

import android.app.Fragment
import android.widget.TextView
import com.github.maksimkirko.bottom_navigation_demo_kotlin.R

abstract class ScreenFragment : Fragment() {

    private var titleTextView: TextView? = null

    fun initTitleView(text: String) {
        if (view != null) {
            titleTextView = view.findViewById(R.id.text_view_fragment_bottom_tab_title)
            titleTextView!!.text = text
        }
        activity.title = text
    }
}