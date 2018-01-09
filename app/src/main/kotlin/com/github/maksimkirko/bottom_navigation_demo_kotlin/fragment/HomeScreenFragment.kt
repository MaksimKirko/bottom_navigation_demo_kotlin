package com.github.maksimkirko.bottom_navigation_demo_kotlin.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.maksimkirko.bottom_navigation_demo_kotlin.R
import com.github.maksimkirko.bottom_navigation_demo_kotlin.util.HomePagerAdapter

class HomeScreenFragment : ScreenFragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: PagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTabLayout()
        initViewPager()

        activity.title = "Home"

    }

    override fun onResume() {
        super.onResume()
        if (::viewPager.isInitialized) {
            viewPager.currentItem = currentTab
        }
    }

    private fun initTabLayout() {
        tabLayout = activity.findViewById(R.id.tab_layout_main)
    }

    private fun initViewPager() {
        pagerAdapter = HomePagerAdapter(childFragmentManager)
        viewPager = view!!.findViewById(R.id.view_pager_fragment_home)
        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
                currentTab = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

    companion object {

        private var currentTab = 0
    }
}
