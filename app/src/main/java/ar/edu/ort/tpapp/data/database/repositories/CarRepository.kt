package ar.edu.ort.tpapp.data.database.repositories

import android.util.Log
import ar.edu.ort.tpapp.data.database.dao.CarDao
import ar.edu.ort.tpapp.data.database.entities.CarEntity
import ar.edu.ort.tpapp.data.database.entities.toDatabase
//import ar.edu.ort.tpapp.data.database.entities.toDatabase
import ar.edu.ort.tpapp.domain.models.Car
import ar.edu.ort.tpapp.domain.models.toDomain
import javax.inject.Inject

class CarRepository  @Inject constructor(
    private val carDao:CarDao
){
    suspend fun getAllCars():List<Car>{

        try {
            Log.i("CarRepository", "getAllCars() - init")
            val response: List<CarEntity> = carDao.getAllCars()
            Log.i("CarRepository", "getAllCars() - out. result.size:" + response.size)
            return response.map { it.toDomain() }
        }catch (e:Exception){
            throw Exception("Error: CarRepository-getAllCars(): "+e.message)
        }


    }

    suspend fun insertCars(cars:List<Car>){
        try{
            Log.i("CarRepository","insertCars("+cars.size+") - init")
            carDao.insertAll(cars.map { it.toDatabase() })
            Log.i("CarRepository","insertCars() - out")
        }catch (e:Exception){
            throw Exception("Error: CarRepository-getAllCars(): "+e.message)
        }
    }

    suspend fun deleteNonFavoriteCars(){
        try {
            Log.i("CarRepository", "deleteNonFavoriteCars() - init")
            carDao.deleteNonFavoriteCars()
            Log.i("CarRepository", "deleteNonFavoriteCars() - out")
        }catch (e:Exception){
            throw Exception("Error: CarRepository-getAllCars(): "+e.message)
        }
    }



}