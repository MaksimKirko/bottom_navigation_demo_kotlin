package com.github.maksimkirko.bottom_navigation_demo_kotlin.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.maksimkirko.bottom_navigation_demo_kotlin.R
import com.github.maksimkirko.bottom_navigation_demo_kotlin.util.HomePagerAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeScreenFragment : ScreenFragment() {

    private lateinit var tabLayout: TabLayout
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
        viewPager.currentItem = currentTab
    }

    private fun initTabLayout() {
        tabLayout = activity.findViewById(R.id.tabLayout)
    }

    private fun initViewPager() {
        pagerAdapter = HomePagerAdapter(childFragmentManager)
        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if (viewPager != null) {
                    viewPager.currentItem = tab.position
                    currentTab = tab.position
                }
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
