package ar.edu.ort.tpapp.ui.views.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tpapp.R
import ar.edu.ort.tpapp.databinding.FragmentCarListBinding
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
    private val viewModel: CarViewModel by activityViewModels()
    private val args:CarListFragmentArgs by navArgs()
    private var adapter:CarRecyclerAdapter= CarRecyclerAdapter(mutableListOf())
    private lateinit var carListTest:MutableList<Car>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("CarListFragment","onCreateView() - init")
        // Inflate the layout for this fragment
        _binding= FragmentCarListBinding.inflate(inflater,container,false)
        val view = binding.root
        initObservers()
        initVmCarList()
        //initTestFun()
        initRecyclerView()



        Log.i("CarListFragment","onCreateView() - out")
        return view
    }



    private fun initRecyclerView(){

        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.carRecycle.layoutManager = linearLayoutManager

        //viewModel.getAllCars()
        //adapter.setData(carListTest)
        binding.carRecycle.adapter = adapter

    }

    private fun initObservers(){
        viewModel.isLoading.observe(viewLifecycleOwner,{
            loadingProgressBar(it)
        })

        viewModel.carList.observe(viewLifecycleOwner) { cars ->
            adapter.setData(cars.toMutableList())
        }
    }
    private fun initVmCarList(){
        var brand= args.brand
        var favorite= args.favorite
        if(!favorite){
            if(!brand.isNullOrEmpty()) {
                viewModel.getAllCarsByBrand(brand)
            } else{viewModel.getAllCars()}
        }else{
            viewModel.getAllFavorites()
        }
    }

    private fun loadingProgressBar(loading:Boolean){
        if(loading){
            binding.pbRvCarList.visibility= View.VISIBLE
            binding.carRecycle.visibility= View.GONE
        }else{
            binding.pbRvCarList.visibility= View.GONE
            binding.carRecycle.visibility= View.VISIBLE
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
             1993,
            lgBrand= R.drawable.lg_toyota))
        }


    }
}