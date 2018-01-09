package com.github.maksimkirko.bottom_navigation_demo_kotlin.fragment.home

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.maksimkirko.bottom_navigation_demo_kotlin.R
import com.github.maksimkirko.bottom_navigation_demo_kotlin.util.RecyclerViewAdapter

abstract class TabFragment : Fragment() {

    var recyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    protected fun initRecyclerView() {
        recyclerView = view.findViewById(R.id.recycler_view_fragment_tab)
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        recyclerView!!.adapter = RecyclerViewAdapter()
    }
}
