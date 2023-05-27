package ar.edu.ort.tpapp.ui.views.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ar.edu.ort.tpapp.R
import ar.edu.ort.tpapp.databinding.FragmentHomeScreenBinding
import ar.edu.ort.tpapp.domain.models.CarBrand
import ar.edu.ort.tpapp.ui.views.adapters.CarBrandRecyclerAdapter


class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {

    private var _binding:FragmentHomeScreenBinding?=null
    private val binding get()= _binding!!

    private lateinit var brandListTest: MutableList<CarBrand>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("HomeScreenFragment","onCreateView() - init")
        // Inflate the layout for this fragment
        _binding= FragmentHomeScreenBinding.inflate(inflater,container,false)
        val view= binding.root
        initTestFun()
        initRecyclerView()
        Log.i("HomeScreenFragment","onCreateView() - testList.size= "+ brandListTest.size)
        Log.i("HomeScreenFragment","onCreateView() - out")
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun initRecyclerView(){
        val linearLayoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        initTestFun()
        binding.rvCardCarBrand.adapter= CarBrandRecyclerAdapter(brandListTest)
        binding.rvCardCarBrand.layoutManager=linearLayoutManager
    }

    private fun initTestFun(){
        brandListTest= mutableListOf(
            CarBrand(("test 1"),"+99",R.drawable.lg_mercedez),
            CarBrand(("test 2"),"+99",R.drawable.lg_mercedez),
            CarBrand(("test 3"),"+99",R.drawable.lg_mercedez),
            CarBrand(("test 4"),"+99",R.drawable.lg_mercedez),
            CarBrand(("test 5"),"+99",R.drawable.lg_mercedez),
            CarBrand(("test 6"),"+99",R.drawable.lg_mercedez),
            CarBrand(("test 7"),"+99",R.drawable.lg_mercedez),
            CarBrand(("test 8"),"+99",R.drawable.lg_mercedez),
            CarBrand(("test 9"),"+99",R.drawable.lg_mercedez),
            CarBrand(("test 10"),"+99",R.drawable.lg_mercedez))


    }


}