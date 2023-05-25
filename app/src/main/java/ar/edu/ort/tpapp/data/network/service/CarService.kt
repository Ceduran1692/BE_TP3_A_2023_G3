package ar.edu.ort.tpapp.data.network.service

import android.util.Log
import ar.edu.ort.tpapp.data.network.service.implementations.CarsServiceImpl
import ar.edu.ort.tpapp.domain.models.Car
import ar.edu.ort.tpapp.domain.models.toDomain
import javax.inject.Inject

class CarService @Inject constructor(private val serviceImpl:CarsServiceImpl) {

    suspend fun getAllCars():List<Car>{
        Log.i("CarService","getAllCars():List<Car> - init")
        val response= serviceImpl.getAllCars()

        Log.i("CarService","result.size= "+ response.size)
        Log.i("CarService","getAllCars() - end")
        return response.map { it.toDomain() }
    }
}