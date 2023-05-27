package ar.edu.ort.tpapp.ui.views.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tpapp.domain.models.Car
import ar.edu.ort.tpapp.ui.views.holders.CarViewHolder

data class CarRecyclerAdapter(
    val carList:MutableList<Car>
):RecyclerView.Adapter<CarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
       // TODO("Not yet implemented")
        return TODO("Provide the return value")
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        var car= carList[position]

        holder.render(car)
    }

    override fun getItemCount(): Int {
        return carList.size
    }
}
