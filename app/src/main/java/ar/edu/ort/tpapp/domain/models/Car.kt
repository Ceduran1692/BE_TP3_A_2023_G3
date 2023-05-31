package ar.edu.ort.tpapp.domain.models

import ar.edu.ort.tpapp.R
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
) {
    init {
        setLogo(this)
    }

    private fun setLogo(car: Car) {
        when (car.make) {
            "mercedes-benz" -> car.lgBrand = R.drawable.lg_mercedez
            "maserati" -> car.lgBrand = R.drawable.lg_maserati
            "toyota" -> car.lgBrand = R.drawable.lg_toyota
            "porsche" -> car.lgBrand = R.drawable.lg_porsche
            "volkswagen" -> car.lgBrand = R.drawable.lg_vw
            "renault" -> car.lgBrand = R.drawable.lg_renault
            "bmw" -> car.lgBrand = R.drawable.lg_bmw
            "audi" -> car.lgBrand = R.drawable.lg_audi
            "fiat" -> car.lgBrand=R.drawable.lg_fiat
            else -> car.lgBrand = R.drawable.lg_bmw
        }
    }
}

fun CarDto.toDomain() = Car(
    city_mpg = city_mpg,
    `class` = `class`,
    combination_mpg = combination_mpg,
    cylinders = cylinders,
    displacement = displacement,
    drive = drive,
    fuel_type = fuel_type,
    highway_mpg = highway_mpg,
    make = make,
    model = model,
    transmission = transmission,
    year = year,
    favorite = favorite
)

