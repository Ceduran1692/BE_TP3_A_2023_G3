package ar.edu.ort.tpapp.data.network.service.interfaces

import ar.edu.ort.tpapp.data.network.dto.CarDto
import retrofit2.Response
import retrofit2.http.GET

interface CarsServiceInterface {

    @GET("/v1/cars?limit=10&make=audi")
    suspend fun getAllCars(): Response<List<CarDto>>
}