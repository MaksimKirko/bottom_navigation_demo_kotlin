package com.github.maksimkirko.bottom_navigation_demo_kotlin.fragment.home

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.maksimkirko.bottom_navigation_demo_kotlin.R
import com.github.maksimkirko.bottom_navigation_demo_kotlin.util.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_tab.*

abstract class TabFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    protected fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = RecyclerViewAdapter()
    }
}
