package ar.edu.ort.tpapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ar.edu.ort.tpapp.domain.models.Car

@Entity(tableName = "car_table")
data class CarEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    @ColumnInfo(name= "city_mpg") val city_mpg: Int,
    @ColumnInfo(name= "_class") val _class: String,
    @ColumnInfo(name= "combination_mpg") val combination_mpg: Int,
    @ColumnInfo(name= "cylinders") val cylinders: Int,
    @ColumnInfo(name= "displacement") val displacement: Double,
    @ColumnInfo(name= "drive") val drive: String,
    @ColumnInfo(name= "fuel_type") val fuel_type: String,
    @ColumnInfo(name= "highway_mpg") val highway_mpg: Int,
    @ColumnInfo(name= "make") val make: String,
    @ColumnInfo(name= "model") val model: String,
    @ColumnInfo(name= "transmission") val transmission: String,
    @ColumnInfo(name= "year") val year: Int,
    @ColumnInfo(name= "favorite") val favorite: Boolean)


fun Car.toDatabase()= CarEntity(city_mpg=city_mpg, _class=`class`, combination_mpg=combination_mpg, cylinders=cylinders, displacement=displacement, drive=drive, fuel_type=fuel_type, highway_mpg=highway_mpg, make=make, model=model, transmission=transmission, year=year,favorite=favorite)
