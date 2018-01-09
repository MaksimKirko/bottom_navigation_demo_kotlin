package com.github.maksimkirko.bottom_navigation_demo_kotlin

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.github.maksimkirko.bottom_navigation_demo_kotlin.fragment.*
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarLayout: AppBarLayout
    private lateinit var toolbar: Toolbar
    private lateinit var tabLayout: TabLayout
    private lateinit var bottomNavigationView: BottomNavigationViewEx
    private var selectedFragment: Fragment? = null

    private var isAppBarLayoutExpanded = true
    private var isHomeFragment = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAppBarLayout()
        initToolbar()
        initTabLayout()
        initNavigationDrawer()
        initBottomNavigationView()
    }

    private fun initAppBarLayout() {
        appBarLayout = findViewById(R.id.app_bar_main)

        appBarLayout.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (isHomeFragment) {
                isAppBarLayoutExpanded = verticalOffset == 0
            }
        }
    }

    private fun initToolbar() {
        toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
    }

    private fun initTabLayout() {
        tabLayout = findViewById(R.id.tab_layout_main)
    }

    private fun initNavigationDrawer() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

    }

    private fun initBottomNavigationView() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view_main)
        bottomNavigationView.setTextVisibility(false)
        bottomNavigationView.enableAnimation(false)
        bottomNavigationView.enableShiftingMode(false)
        bottomNavigationView.enableItemShiftingMode(false)

        val menu = bottomNavigationView.menu
        selectScreen(menu.getItem(0))

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            selectScreen(item)
            false
        }

    }

    private fun selectScreen(item: MenuItem) {
        item.isChecked = true

        when (item.itemId) {
            R.id.action_home -> {
                appBarLayout.setExpanded(isAppBarLayoutExpanded, false)
                tabLayout.visibility = View.VISIBLE
                initFragment(HomeScreenFragment())
                isHomeFragment = true
            }
            R.id.action_gallery -> {
                showAppBarLayout()
                initFragment(GalleryScreenFragment())
            }
            R.id.action_manage -> {
                showAppBarLayout()
                initFragment(ManageScreenFragment())
            }
            R.id.action_send -> {
                showAppBarLayout()
                initFragment(SendScreenFragment())
            }
            R.id.action_share -> {
                showAppBarLayout()
                initFragment(ShareScreenFragment())
            }
        }
    }

    private fun showAppBarLayout() {
        tabLayout.visibility = View.GONE
        appBarLayout.setExpanded(true, false)
        isHomeFragment = false
    }

    private fun initFragment(fragment: Fragment) {
        val fragmentManager = fragmentManager
        if (fragmentManager != null) {
            val ft = fragmentManager.beginTransaction()
            if (ft != null) {
                if (selectedFragment != null) {
                    ft.remove(selectedFragment)
                }
                ft.add(R.id.layout_activity_main_fragment_container, fragment)
                ft.commit()
            }
        }
        selectedFragment = fragment
    }


    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
