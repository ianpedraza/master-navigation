package com.ianpedraza.masternavigation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.ianpedraza.masternavigation.R
import com.ianpedraza.masternavigation.databinding.ActivityMainBinding
import com.ianpedraza.masternavigation.utils.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private val navController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navHostFragment.navController
    }

    private lateinit var appBarConfiguration: AppBarConfiguration

    /* Define the fragments to show within the NavView */
    private val fragments = setOf(
        R.id.mailFragment,
        R.id.videoCallFragment,
        R.id.inboxFragment,
        R.id.starredFragment,
        R.id.snoozedFragment
    )

    private val drawerGravity = GravityCompat.START

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        /* Ids in nav_graph.xml should be the same in menu.xml */
        setupActionBar()
        setupNavigationDrawer()
        setupBottomNavigationBar()
    }

    private fun setupActionBar() {
        appBarConfiguration = AppBarConfiguration(fragments, binding.drawerLayout)
        NavigationUI.setupWithNavController(binding.topAppBar, navController, appBarConfiguration)

        /* When using default actionbar (change theme to ActionBar) */
        // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    private fun setupBottomNavigationBar() {
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)

        val badgeMail = binding.bottomNavigationView.getOrCreateBadge(R.id.mailFragment).apply {
            isVisible = true
            number = 99
        }

        val badgeVideoCalls =
            binding.bottomNavigationView.getOrCreateBadge(R.id.videoCallFragment).apply {
                isVisible = true
            }

        // To hide a badge already created
        /*binding.bottomNavigationView.getBadge(R.id.videoCallFragment)?.let { badgeDrawable ->
            badgeDrawable.isVisible = false
            badgeDrawable.clearNumber()
        }*/

        // binding.bottomNavigationView.removeBadge(R.id.mailFragment)
    }

    private fun setupNavigationDrawer() {
        NavigationUI.setupWithNavController(binding.navigationView, navController)
        navController.addOnDestinationChangedListener(onDestinationChangedListener)
        onBackPressedDispatcher.addCallback(backPressedCallBack)
        // binding.navigationView.setNavigationItemSelectedListener(navigationItemSelectedListener)
    }

    private val backPressedCallBack = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (binding.drawerLayout.isDrawerOpen(drawerGravity)) {
                closeDrawer()
            } else {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    private val onDestinationChangedListener: NavController.OnDestinationChangedListener by lazy {
        NavController.OnDestinationChangedListener { controller, destination, _ ->
            when (destination.id) {
                R.id.settingsFragment -> {
                    hideBottomNavView(true)
                    clearSelection()
                }
                R.id.helpFragment -> {
                    hideBottomNavView(true)
                    clearSelection()
                }
                else -> hideBottomNavView(false)
            }
        }
    }

    private fun clearSelection() {
        binding.navigationView.checkedItem?.isChecked = false
    }

    private fun hideBottomNavView(hide: Boolean) {
        binding.bottomNavigationView.visibility = if (hide) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    private val navigationItemSelectedListener: NavigationView.OnNavigationItemSelectedListener by lazy {
        NavigationView.OnNavigationItemSelectedListener { destination ->
            val handled = NavigationUI.onNavDestinationSelected(destination, navController)
            closeDrawer()
            handled
        }
    }

    private fun closeDrawer() = binding.drawerLayout.closeDrawer(drawerGravity)

    override fun onSupportNavigateUp(): Boolean =
        NavigationUI.navigateUp(navController, appBarConfiguration)
}
