package com.github.maksimkirko.bottom_navigation_demo_kotlin.util

import android.app.Fragment
import android.app.FragmentManager
import android.support.v13.app.FragmentStatePagerAdapter
import com.github.maksimkirko.bottom_navigation_demo_kotlin.fragment.home.FirstTabFragment
import com.github.maksimkirko.bottom_navigation_demo_kotlin.fragment.home.SecondTabFragment
import com.github.maksimkirko.bottom_navigation_demo_kotlin.fragment.home.TabFragment
import com.github.maksimkirko.bottom_navigation_demo_kotlin.fragment.home.ThirdTabFragment

class HomePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        var tabFragment: TabFragment? = null
        when (position) {
            0 -> tabFragment = FirstTabFragment()
            1 -> tabFragment = SecondTabFragment()
            2 -> tabFragment = ThirdTabFragment()
        }
        return tabFragment
    }

    override fun getCount(): Int {
        return TABS_COUNT
    }

    companion object {

        private val TABS_COUNT = 3
    }
}