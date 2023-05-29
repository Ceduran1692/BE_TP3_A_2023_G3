package ar.edu.ort.tpapp.ui.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import ar.edu.ort.tpapp.R
import ar.edu.ort.tpapp.databinding.ActivityMainBinding
import ar.edu.ort.tpapp.ui.viewmodels.CarViewModel
import ar.edu.ort.tpapp.ui.views.fragments.CarListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    //private val carViewModel: CarViewModel by viewModels()

    private lateinit var navController: NavController
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
    }

}