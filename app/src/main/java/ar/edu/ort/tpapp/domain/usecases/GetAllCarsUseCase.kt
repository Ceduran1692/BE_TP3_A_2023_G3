package ar.edu.ort.tpapp.domain.usecases

import android.util.Log
import ar.edu.ort.tpapp.data.network.service.CarService
import ar.edu.ort.tpapp.domain.models.Car
import javax.inject.Inject

class GetAllCarsUseCase @Inject constructor(private val carService:CarService){

    suspend operator fun invoke():List<Car>{
        Log.i("GetAllCarsUseCase:List<Car>", "init")

        val result= carService.getAllCars()

        Log.i("GetAllCarsUseCase", "result.size= "+ result.size)
        Log.i("GetAllCarsUseCase", "finish")
    return result

    }

}