package com.github.maksimkirko.bottom_navigation_demo_kotlin.fragment.home

import android.support.v7.widget.LinearLayoutManager

class SecondTabFragment : TabFragment() {

    override fun onResume() {
        super.onResume()
        recyclerView!!.scrollToPosition(currentPosition)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        currentPosition = (recyclerView!!.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
    }

    companion object {

        private var currentPosition = 0
    }
}