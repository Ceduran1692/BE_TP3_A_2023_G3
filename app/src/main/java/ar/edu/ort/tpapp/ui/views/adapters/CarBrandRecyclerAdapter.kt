package ar.edu.ort.tpapp.ui.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tpapp.R
import ar.edu.ort.tpapp.domain.models.CarBrand
import ar.edu.ort.tpapp.ui.views.holders.CarBrandViewHolder

class CarBrandRecyclerAdapter(
    private val carBrandList:MutableList<CarBrand>
):RecyclerView.Adapter<CarBrandViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarBrandViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_rv_card_car_brand,parent,false)
        return CarBrandViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carBrandList.size
    }

    override fun onBindViewHolder(holder: CarBrandViewHolder, position: Int) {
        var brand= carBrandList[position]

        holder.render(brand)
    }

}