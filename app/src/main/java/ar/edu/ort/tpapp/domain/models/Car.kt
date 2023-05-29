package ar.edu.ort.tpapp.domain.models

import ar.edu.ort.tpapp.data.database.entities.CarEntity
import ar.edu.ort.tpapp.data.network.dto.CarDto

data class Car(
    var city_mpg: Int,
    var `class`: String,
    var combination_mpg: Int,
    var cylinders: Int,
    var displacement: Double,
    var drive: String,
    var fuel_type: String,
    var highway_mpg: Int,
    var make: String,
    var model: String,
    var transmission: String,
    var year: Int,
    var favorite: Boolean= false,
    var lgBrand: Int= 0
)

fun CarDto.toDomain()= Car( city_mpg=city_mpg, `class`=`class`, combination_mpg=combination_mpg, cylinders=cylinders, displacement=displacement, drive=drive, fuel_type=fuel_type, highway_mpg=highway_mpg, make=make, model=model, transmission=transmission, year=year, favorite=favorite)
fun CarEntity.toDomain()= Car(city_mpg, `class`=_class, combination_mpg, cylinders, displacement, drive, fuel_type, highway_mpg, make, model, transmission, year, favorite)