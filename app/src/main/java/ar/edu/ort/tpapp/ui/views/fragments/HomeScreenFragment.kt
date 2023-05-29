package ar.edu.ort.tpapp.ui.views.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ar.edu.ort.tpapp.R
import ar.edu.ort.tpapp.databinding.FragmentHomeScreenBinding
import ar.edu.ort.tpapp.domain.models.CarBrand
import ar.edu.ort.tpapp.ui.viewmodels.CarViewModel
import ar.edu.ort.tpapp.ui.views.adapters.CarBrandRecyclerAdapter
import ar.edu.ort.tpapp.ui.views.listeners.OnClickBrand
import com.google.android.material.card.MaterialCardView


class HomeScreenFragment : OnClickBrand, Fragment(R.layout.fragment_home_screen) {

    private var _binding:FragmentHomeScreenBinding?=null
    private val binding get()= _binding!!
    private val carViewModel:CarViewModel by activityViewModels()

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
        binding.rvCardCarBrand.adapter= CarBrandRecyclerAdapter(brandListTest,this)
        binding.rvCardCarBrand.layoutManager=linearLayoutManager
    }



    private fun initTestFun(){
           brandListTest = mutableListOf(
               CarBrand(("maserati"), "", R.drawable.lg_maserati),
               CarBrand(("mercedes-benz"), "", R.drawable.lg_mercedez),
               CarBrand(("toyota"), "", R.drawable.lg_toyota),
               CarBrand(("porsche"), "", R.drawable.lg_porsche),
               CarBrand(("volkswagen"), "", R.drawable.lg_vw),
               CarBrand(("renault"), "", R.drawable.lg_renault),
               CarBrand(("bmw"), "", R.drawable.lg_bmw),
               CarBrand(("fiat"), "", R.drawable.lg_fiat),
               CarBrand(("audi"), "", R.drawable.lg_audi),

           )
    }

    override fun onClickBrandRedirect(card: MaterialCardView,brand:String) {
        Log.i("HomeScreenFragment","onClickBrandRedirect() - in")
        /*
        card.setOnClickListener {
            Log.i("HomeScreenFragment","onClickBrandRedirect() - in")
            carViewModel.getAllCarsByBrand(brand)
            Log.i("HomeScreenFragment","carViewModel.carList.value[0].make= "+carViewModel.carList.value.orEmpty()[0].make)
            findNavController().navigate(R.id.action_homeScreenFragment_to_carListFragment)
        }
*/
        Log.i("HomeScreenFragment","onClickBrandRedirect() - out")
    }

}