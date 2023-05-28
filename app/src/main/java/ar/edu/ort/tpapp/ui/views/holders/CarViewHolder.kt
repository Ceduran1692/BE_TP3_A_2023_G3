package ar.edu.ort.tpapp.ui.views.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tpapp.R
import ar.edu.ort.tpapp.domain.models.Car

data class CarViewHolder(private val view: View):RecyclerView.ViewHolder(view){
    //TODO CREATE CARDVIEW
    val cardTitle: TextView = view.findViewById(R.id.card_title)

    fun render(item: Car){
    //TODO MAP CARDVIEW FROM CAR
        cardTitle.text = item.model
    }
}
