package ar.edu.ort.tpapp.domain.usecases

import android.util.Log
import ar.edu.ort.tpapp.core.Config
import ar.edu.ort.tpapp.data.network.service.CarService
import ar.edu.ort.tpapp.domain.models.Car
import java.util.Collections
import javax.inject.Inject

class GetAllCarsUseCase @Inject constructor(
    private val carService:CarService
){

    suspend operator fun invoke():MutableList<Car>{
        try {
            Log.i("GetAllCarsUseCase:List<Car>", "init")

            var result:MutableList<Car>

            result= mutableListOf()

            for(brand in Config.brands){
                result.addAll(carService.getAllCarsByBrand(brand))
            }

            Log.i("GetAllCarsUseCase", "out")
            Collections.shuffle(result)
            return result
        }catch (e:Exception){
            Log.i("GetAllCarsUseCase","Error: GetAllCarsUseCase: "+e.message)
            return mutableListOf()
        }
    }


}