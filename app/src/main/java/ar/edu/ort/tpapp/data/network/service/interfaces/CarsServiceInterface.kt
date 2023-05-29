package ar.edu.ort.tpapp.data.network.service.interfaces

import ar.edu.ort.tpapp.data.network.dto.CarDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CarsServiceInterface {

    @GET("/v1/cars?limit=50&make=audi")
    suspend fun getAllCars(): Response<List<CarDto>>

    @GET("/v1/cars?limit=10")
    suspend fun getAllCarsbyBrand(@Query("make")make:String): Response<List<CarDto>>
}