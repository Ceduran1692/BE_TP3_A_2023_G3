package ar.edu.ort.tpapp.domain.usecases

import android.util.Log
import ar.edu.ort.tpapp.data.database.repositories.CarRepository
import ar.edu.ort.tpapp.data.network.service.CarService
import ar.edu.ort.tpapp.domain.models.Car
import javax.inject.Inject

class GetAllCarsByBrandUseCase @Inject constructor(
    private val carService: CarService,
    private val carRepository: CarRepository) {

    suspend operator fun invoke(brand:String):MutableList<Car>{
        try {
            Log.i("GetAllCarsByBrand:List<Car>", "init")
            var result = carService.getAllCarsByBrand(brand)
            if(!result.isEmpty()){
                carRepository.insertCars(result)
                Log.i("GetAllCarsByBrand:List<Car>", "insert validation:"+ carRepository.getAllCars().size)
            }else{
                result= carRepository.getAllCarsByBrand(brand)
            }
            Log.i("GetAllCarsByBrand", "out")
            return result.toMutableList()
        }catch (e:Exception){
            Log.i("GetAllCarsByBrand","Error: GetAllCarsByBrand: "+e.message)
            return emptyList<Car>().toMutableList()
        }
    }
}