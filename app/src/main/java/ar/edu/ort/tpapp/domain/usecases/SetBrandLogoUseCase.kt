package ar.edu.ort.tpapp.domain.usecases

import android.util.Log
import ar.edu.ort.tpapp.R
import ar.edu.ort.tpapp.domain.models.Car
import ar.edu.ort.tpapp.domain.models.CarBrand
import javax.inject.Inject

class SetBrandLogoUseCase @Inject constructor(){

    suspend operator fun invoke(list: MutableList<Car>):MutableList<Car>{
        try {
            Log.i("GetAllCarsUseCase:List<Car>", "init")
            list.forEach{ car ->
                setLogo(car)
            }

            Log.i("GetAllCarsUseCase", "out re")
            return list
        }catch (e:Exception){
            Log.i("GetAllCarsUseCase","Error: GetAllCarsUseCase: "+e.message)
            return emptyList<Car>().toMutableList()
        }
    }

    private fun setLogo(car:Car){
        when(car.make){
            "mercedes-benz"-> car.lgBrand= R.drawable.lg_mercedez
            "maserati"-> car.lgBrand= R.drawable.lg_maserati
            "toyota"-> car.lgBrand= R.drawable.lg_toyota
            "porsche"-> car.lgBrand= R.drawable.lg_porsche
            "volkswagen"-> car.lgBrand= R.drawable.lg_vw
            "renault"-> car.lgBrand= R.drawable.lg_renault
            "bmw"-> car.lgBrand= R.drawable.lg_bmw
            else -> car.lgBrand= R.drawable.lg_bmw
        }
    }


}