package ar.edu.ort.tpapp.domain.models

import ar.edu.ort.tpapp.data.database.entities.CarsEntity
import ar.edu.ort.tpapp.data.network.dto.CarDto

data class Car(
    val city_mpg: Int,
    val `class`: String,
    val combination_mpg: Int,
    val cylinders: Int,
    val displacement: Double,
    val drive: String,
    val fuel_type: String,
    val highway_mpg: Int,
    val make: String,
    val model: String,
    val transmission: String,
    val year: Int,
    val favorite: Boolean
)

fun CarDto.toDomain()= Car( city_mpg, `class`, combination_mpg, cylinders, displacement, drive, fuel_type, highway_mpg, make, model, transmission, year, favorite)
fun CarsEntity.toDomain()= Car( city_mpg, `class`, combination_mpg, cylinders, displacement, drive, fuel_type, highway_mpg, make, model, transmission, year, favorite)