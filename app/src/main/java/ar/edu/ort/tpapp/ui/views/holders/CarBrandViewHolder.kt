package ar.edu.ort.tpapp.ui.views.holders

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tpapp.R
import ar.edu.ort.tpapp.domain.models.CarBrand

data class CarBrandViewHolder(private val view: View):RecyclerView.ViewHolder(view){

    val brandName= view.findViewById<TextView>(R.id.tv_card_brand_name)
    val brandImg= view.findViewById<ImageView>(R.id.iv_card_brand)
    val brandCount= view.findViewById<TextView>(R.id.tv_card_brand_count)

    fun render(item:CarBrand){
        brandName.text= item.name
        brandCount.text= item.count
        brandImg.setImageDrawable(ContextCompat.getDrawable(view.context,item.logo))

    }

}
