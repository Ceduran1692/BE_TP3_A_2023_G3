package ar.edu.ort.tpapp.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tpapp.R
import ar.edu.ort.tpapp.databinding.FragmentCarListBinding
import ar.edu.ort.tpapp.databinding.FragmentHomeScreenBinding
import ar.edu.ort.tpapp.domain.models.Car
import ar.edu.ort.tpapp.domain.models.CarBrand
import ar.edu.ort.tpapp.ui.viewmodels.CarViewModel
import ar.edu.ort.tpapp.ui.views.adapters.CarBrandRecyclerAdapter
import ar.edu.ort.tpapp.ui.views.adapters.CarRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarListFragment : Fragment(R.layout.fragment_car_list) {
    private var _binding: FragmentCarListBinding?=null
    private val binding get()= _binding!!
    private val viewModel: CarViewModel by viewModels()

    private lateinit var carListTest:MutableList<Car>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentCarListBinding.inflate(inflater,container,false)
        val view = binding.root
        initRecyclerView()

        return view
    }



    private fun initRecyclerView(){
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.carRecycle.layoutManager = linearLayoutManager

        viewModel.getAllCars()

        viewModel.carList.observe(viewLifecycleOwner) { cars ->
            val adapter = CarRecyclerAdapter(cars.toMutableList())
            binding.carRecycle.adapter = adapter
        }
    }

    private fun initTestFun(){
        carListTest= mutableListOf()

        for(i in 1..5){
            carListTest.add(Car(  18,
                "midsize car",
            21,
             4,
             2.2,
             "fwd",
             "gas",
             26,
            "toyota",
            "camry",
            "a",
             1993))
        }


    }
}