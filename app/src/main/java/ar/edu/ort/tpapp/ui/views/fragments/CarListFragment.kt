package ar.edu.ort.tpapp.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tpapp.R
import ar.edu.ort.tpapp.domain.models.Car
import ar.edu.ort.tpapp.ui.viewmodels.CarViewModel
import ar.edu.ort.tpapp.ui.views.adapters.CarRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarListFragment : Fragment() {
    private val carViewModel: CarViewModel by viewModels()

    private lateinit var carRecycleView: RecyclerView
    private lateinit var carAdapter: CarRecyclerAdapter
    private var carList: MutableList<Car> = carViewModel.getCarsList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_car_list, container, false)
        carRecycleView = view.findViewById(R.id.carRecycle)
        carAdapter = CarRecyclerAdapter(carList)
        carRecycleView.adapter = carAdapter
        carViewModel.getCarsList()?.let { carAdapter.setData(it) }
        return view
    }

    fun getCarList(): MutableList<Car>{
        return carViewModel.getCarsList()
    }
}