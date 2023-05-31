package ar.edu.ort.tpapp.ui.views.activities

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import ar.edu.ort.tpapp.R
import ar.edu.ort.tpapp.databinding.ActivityMainBinding
import ar.edu.ort.tpapp.ui.viewmodels.CarViewModel
import ar.edu.ort.tpapp.ui.views.fragments.CarListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, NavController.OnDestinationChangedListener {

    private lateinit var binding:ActivityMainBinding
    //private val carViewModel: CarViewModel by viewModels()

    private lateinit var navController: NavController

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("MainActivity","entro onCreate()")


        /*carViewModel.carList.observe(this, Observer {
            Log.i("MainActivity","carViewModel.carList.size: "+ it.size)
        })

        carViewModel.getAllCars()*/

        Log.i("Main Activity","salgo onCreate()")

        //TOOLBAR
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //NAV CONTROLLER
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        drawer = findViewById(R.id.DrawerLayout)
        toggle = ActionBarDrawerToggle( this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        //BOTTOM NAVIGATION
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bottom_navigation_home -> {
                    navController.navigate(R.id.homeScreenFragment)
                }
                R.id.bottom_navigation_cars -> {
                    navController.navigate(R.id.carListFragment)
                }
                R.id.bottom_navigation_search -> {
                    navController.navigate(R.id.carListFragment)
                }
                R.id.bottom_navigation_profile -> {
                    navController.navigate(R.id.profileFragment)
                }
            }
            true
        }
        navigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)
        navController.addOnDestinationChangedListener(this)
    }

    fun updateHeaderName(){

        val headerView : View = navigationView.getHeaderView(0)

        headerView.findViewById<TextView?>(R.id.txtHeaderMenuName).text = getName()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_profile -> navController.navigate(R.id.profileFragment)
            R.id.menu_configuration -> navController.navigate(R.id.settingFragment)
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.setToolbarNavigationClickListener{
            navController.navigateUp()
        }
    }
    override fun onDestinationChanged(controller: NavController, destination: NavDestination, arguments: Bundle?) {
        if (destination.id == R.id.homeScreenFragment) {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            toggle.isDrawerIndicatorEnabled = true
        } else {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            toggle.isDrawerIndicatorEnabled = false
            toggle.setHomeAsUpIndicator(R.drawable.arrow_back_home)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        if (navController.currentDestination?.id != R.id.homeScreenFragment) {
            navController.navigate(R.id.homeScreenFragment)
            return true
        }
        return super.onSupportNavigateUp()
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getName():String{
        val sharedPreferences = applicationContext.getSharedPreferences("loginPreferences", Context.MODE_PRIVATE)
        return sharedPreferences.getString("nombre", "") ?: ""
    }
}