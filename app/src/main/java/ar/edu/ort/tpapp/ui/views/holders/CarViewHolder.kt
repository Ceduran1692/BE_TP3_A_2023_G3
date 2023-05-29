package ar.edu.ort.tpapp.ui.views.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tpapp.R
import ar.edu.ort.tpapp.domain.models.Car

data class CarViewHolder(private val view: View):RecyclerView.ViewHolder(view){
    //TODO CREATE CARDVIEW
    val cardTitle: TextView = view.findViewById(R.id.card_title)
    val cardTransmission: TextView = view.findViewById((R.id.card_transmission))
    val cardFuel: TextView = view.findViewById((R.id.card_fuel))
    val cardYear: TextView = view.findViewById(R.id.card_year)
    val logoBrand = view.findViewById<ImageView>(R.id.carLogo)

    fun render(car: Car){
    //TODO MAP CARDVIEW FROM CAR
        cardTitle.text = car.model
        cardTransmission.text = car.transmission
        cardFuel.text = car.fuel_type
        cardYear.text = car.year.toString()
        logoBrand.setImageDrawable(ContextCompat.getDrawable(view.context,car.lgBrand))
    }
}
