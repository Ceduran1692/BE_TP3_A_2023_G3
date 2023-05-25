package ar.edu.ort.tpapp.ui.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import ar.edu.ort.tpapp.databinding.ActivityMainBinding
import ar.edu.ort.tpapp.ui.viewmodels.CarViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val carViewModel: CarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("MainActivity","entro onCreate()")

        carViewModel.carList.observe(this, Observer {
            Log.i("MainActivity","carViewModel.carList.size: "+ it.size)
        })

        carViewModel.getAllCars()

        Log.i("Main Activity","salgo onCreate()")
    }
}