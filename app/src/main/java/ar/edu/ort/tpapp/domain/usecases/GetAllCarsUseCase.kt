package ar.edu.ort.tpapp.domain.usecases

import android.util.Log
import ar.edu.ort.tpapp.data.database.dao.CarDao
import ar.edu.ort.tpapp.data.database.repositories.CarRepository
import ar.edu.ort.tpapp.data.network.service.CarService
import ar.edu.ort.tpapp.domain.models.Car
import javax.inject.Inject

class GetAllCarsUseCase @Inject constructor(
    private val carService:CarService,
    private val carRepository: CarRepository
){

    suspend operator fun invoke():MutableList<Car>{
        try {
            Log.i("GetAllCarsUseCase:List<Car>", "init")
            var result = carService.getAllCars()
            if(!result.isEmpty()){
                carRepository.deleteNonFavoriteCars()

                carRepository.insertCars(result)
                Log.i("GetAllCarsUseCase:List<Car>", "insert validation:"+ carRepository.getAllCars().size)


            }else{
                result= carRepository.getAllCars()
            }
            Log.i("GetAllCarsUseCase", "out")
            return result.toMutableList()
        }catch (e:Exception){
            Log.i("GetAllCarsUseCase","Error: GetAllCarsUseCase: "+e.message)
            return emptyList<Car>().toMutableList()
        }
    }

}