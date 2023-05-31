package ar.edu.ort.tpapp.ui.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tpapp.R
import ar.edu.ort.tpapp.domain.models.Car
import ar.edu.ort.tpapp.ui.views.holders.CarViewHolder

class CarRecyclerAdapter(
    var carList:MutableList<Car>
):RecyclerView.Adapter<CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_card, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        var car= carList[position]

        holder.render(car)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    fun setData(cars: MutableList<Car>) {
        carList.clear()
        carList = cars
        notifyDataSetChanged()
    }
}
