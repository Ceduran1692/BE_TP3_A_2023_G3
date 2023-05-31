package ar.edu.ort.tpapp.data.network.service.implementations

import android.util.Log
import ar.edu.ort.tpapp.data.network.service.interfaces.CarsServiceInterface
import ar.edu.ort.tpapp.data.network.dto.CarDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CarsServiceImpl @Inject constructor(private val service: CarsServiceInterface){
    suspend fun getAllCars():List<CarDto>{
        Log.i("CarServiceImp","getAllCars():List<Car>")
        return withContext(Dispatchers.IO){
            val response= service.getAllCars()
            response.body()?: emptyList()
        }
    }

    suspend fun getAllCarsByBrand(brand:String):List<CarDto>{
        Log.i("CarServiceImp","getAllCarsByBrand("+brand+"):List<Car>")
        return withContext(Dispatchers.IO){
            val response= service.getAllCarsbyBrand(brand)
            response.body()?: emptyList()
        }
    }
}