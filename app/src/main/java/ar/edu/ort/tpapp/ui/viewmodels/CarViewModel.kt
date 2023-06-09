package ar.edu.ort.tpapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.tpapp.domain.models.Car
import ar.edu.ort.tpapp.domain.usecases.GetAllCarsByBrandUseCase
import ar.edu.ort.tpapp.domain.usecases.GetAllCarsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CarViewModel @Inject constructor(
    private val getAllCarsUseCase: GetAllCarsUseCase,
    private val getAllCarsByBrandUseCase: GetAllCarsByBrandUseCase
):ViewModel(){

    val carList= MutableLiveData<List<Car>>()
    val favoriteCarList= MutableLiveData<MutableList<Car>>()
    val isLoading= MutableLiveData<Boolean>()



    fun getAllCars(){
        Log.i("CarViewModel", "getAllCars() - init")
        isLoading.postValue(true)
        viewModelScope.launch {
            var result= getAllCarsUseCase()

            if(result.isNotEmpty()) {
                Log.i("CarViewModel", "brandVerify-> result[0].lgBrand= +"+result[0].lgBrand)
                setDescriptions(result)
                carList.postValue(result)
            }
            isLoading.postValue(false)
        }
        Log.i("CarViewModel", "getAllCars() - out")

    }

    fun getAllCarsByBrand(brand:String){
        Log.i("CarViewModel", "getAllCarsByBrand() - init")
        isLoading.postValue(true)
        viewModelScope.launch {
            var result= getAllCarsByBrandUseCase(brand)
            if(result.isNotEmpty()) {
                setDescriptions(result)
                carList.value = result
            }
            isLoading.postValue(false)
        }

        Log.i("CarViewModel", "getAllCarsByBrand() - out")

    }

    private fun setDescriptions(cars: List<Car>) {
        cars.forEach { car ->
            car.transmission = when (car.transmission) {
                "a" -> "Automatic"
                "m" -> "Manual"
                else -> "No definida"
            }
            car.model = when (car.make) {
                "mercedes-benz" -> "Mercedes-Benz " + car.model.replaceFirstChar { it.uppercaseChar() }
                "maserati" -> "Maserati "+ car.model.replaceFirstChar { it.uppercaseChar() }
                "toyota" -> "Toyota "+ car.model.replaceFirstChar { it.uppercaseChar() }
                "porsche" -> "Porsche "+ car.model.replaceFirstChar { it.uppercaseChar() }
                "volkswagen" -> "Volkswagen "+ car.model.replaceFirstChar { it.uppercaseChar() }
                "renault" -> "Renault "+ car.model.replaceFirstChar { it.uppercaseChar() }
                "bmw" -> "BMW "+ car.model.replaceFirstChar { it.uppercaseChar() }
                "audi" -> "Audi "+ car.model.replaceFirstChar { it.uppercaseChar() }
                "fiat" -> "Fiat "+ car.model.replaceFirstChar { it.uppercaseChar() }
                else -> car.model.replaceFirstChar { it.uppercaseChar() }
            }
            car.fuel_type = when (car.fuel_type) {
                "gas" -> "Gasoline"
                else -> "Biodiesel"
            }
        }
    }

    fun getAllFavorites(){
        //TODO

    }

    fun getCarsList():MutableList<Car>{
        var response: MutableList<Car>
        if(carList.value == null){
            response = mutableListOf()
        }else{
            response = carList.value!!.toMutableList()
        }
        return response
    }
}