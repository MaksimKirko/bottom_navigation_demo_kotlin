package com.github.maksimkirko.bottom_navigation_demo_kotlin.fragment

import android.app.Fragment
import kotlinx.android.synthetic.main.fragment_default_screen.*

abstract class ScreenFragment : Fragment() {

    fun initTitleView(text: String) {
        if (view != null) {
            titleTextView!!.text = text
        }
        activity.title = text
    }
}