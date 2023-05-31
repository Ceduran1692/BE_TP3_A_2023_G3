package ar.edu.ort.tpapp.domain.usecases

import android.util.Log
import ar.edu.ort.tpapp.data.network.service.CarService
import ar.edu.ort.tpapp.domain.models.Car
import javax.inject.Inject

class GetAllCarsByBrandUseCase @Inject constructor(
    private val carService: CarService) {

    suspend operator fun invoke(brand:String):MutableList<Car>{
        try {
            Log.i("GetAllCarsByBrand:List<Car>", "init")
            var result = carService.getAllCarsByBrand(brand)
            Log.i("GetAllCarsByBrand", "out")
            return result.toMutableList()
        }catch (e:Exception){
            Log.i("GetAllCarsByBrand","Error: GetAllCarsByBrand: "+e.message)
            return emptyList<Car>().toMutableList()
        }
    }
}