package ar.edu.ort.tpapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.tpapp.domain.models.Car
import ar.edu.ort.tpapp.domain.usecases.GetAllCarsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CarViewModel @Inject constructor(
    private val getAllCarsUseCase: GetAllCarsUseCase
):ViewModel(){

    val carList= MutableLiveData<List<Car>>()

    fun getAllCars(){
        Log.i("CarViewModel", "getAllCars() - init")
        viewModelScope.launch {
            val result= getAllCarsUseCase()
            if(result.isNotEmpty())carList.postValue(result)
        }
        Log.i("CarViewModel", "getAllCars() - end")

    }

    fun getAllFavorites(){
        //TODO

    }
}