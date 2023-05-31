package ar.edu.ort.tpapp.ui.views.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import ar.edu.ort.tpapp.R
import ar.edu.ort.tpapp.databinding.FragmentCarListBinding
import ar.edu.ort.tpapp.domain.models.Car
import ar.edu.ort.tpapp.ui.viewmodels.CarViewModel
import ar.edu.ort.tpapp.ui.views.adapters.CarRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarListFragment : Fragment(R.layout.fragment_car_list) {
    private var _binding: FragmentCarListBinding?=null
    private val binding get()= _binding!!
    private val viewModel: CarViewModel by activityViewModels()
    private val args:CarListFragmentArgs by navArgs()
    private lateinit var adapter:CarRecyclerAdapter
    private lateinit var carListTest:MutableList<Car>
    private lateinit var overlayView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("CarListFragment","onCreateView() - init")
        // Inflate the layout for this fragment
        _binding= FragmentCarListBinding.inflate(inflater,container,false)
        val view = binding.root

        overlayView = binding.overlayView

        binding.carListSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterCarList(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterCarList(newText)
                if (newText.isNullOrEmpty()) {
                    overlayView.visibility = if (binding.carListSearch.hasFocus()) View.VISIBLE else View.GONE
                } else {
                    overlayView.visibility = View.VISIBLE
                }
                return true
            }

        })

        Log.i("CarListFragment","onCreateView() - out")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        initVmCarList()
        initRecyclerView()

    }


    private fun initRecyclerView(){

        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.carRecycle.layoutManager = linearLayoutManager

        //viewModel.getAllCars()
        //adapter.setData(carListTest)
        adapter = CarRecyclerAdapter(mutableListOf())
        binding.carRecycle.adapter = adapter

    }

    private fun initObservers() {
        viewModel.isLoading.observe(viewLifecycleOwner, { loading ->
            loadingProgressBar(loading)
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


    private fun loadingProgressBar(loading: Boolean) {
        if (loading) {
            binding.pbRvCarList.visibility = View.VISIBLE
            binding.carRecycle.visibility = View.GONE
        } else {
            binding.pbRvCarList.visibility = View.GONE
            binding.carRecycle.visibility = View.VISIBLE
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun filterCarList(query: String?) {
        query?.let {
            if (::adapter.isInitialized) {
                val filteredList = if (query.isEmpty()) {
                    viewModel.carList.value?.toMutableList() ?: mutableListOf()
                } else {
                    viewModel.carList.value?.filter { car ->
                        car.model.contains(query, ignoreCase = true)
                    }?.toMutableList() ?: mutableListOf()
                }
                adapter.setData(filteredList)
            }
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