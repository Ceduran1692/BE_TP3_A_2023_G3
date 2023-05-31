package ar.edu.ort.tpapp.domain.usecases

import android.util.Log
import ar.edu.ort.tpapp.core.Config
import ar.edu.ort.tpapp.data.database.repositories.CarRepository
import ar.edu.ort.tpapp.data.network.service.CarService
import ar.edu.ort.tpapp.domain.models.Car
import java.util.Collections
import javax.inject.Inject

class GetAllCarsUseCase @Inject constructor(
    private val carService:CarService,
    private val carRepository: CarRepository
){

    suspend operator fun invoke():MutableList<Car>{
        try {
            Log.i("GetAllCarsUseCase:List<Car>", "init")
            carRepository.deleteNonFavoriteCars()

            var result:MutableList<Car>

            result= mutableListOf()

            for(brand in Config.brands){
                result.addAll(carService.getAllCarsByBrand(brand))
            }

            if(!result.isEmpty()){
                carRepository.deleteNonFavoriteCars()

                carRepository.insertCars(result)
                Log.i("GetAllCarsUseCase:List<Car>", "insert validation:"+ carRepository.getAllCars().size)


            }else{
                result= carRepository.getAllCars().toMutableList()
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