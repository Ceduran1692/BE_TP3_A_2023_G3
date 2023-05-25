package ar.edu.ort.tpapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class CarDto(
    @SerializedName("city_mpg")val city_mpg: Int,
    @SerializedName("class")val `class`: String,
    @SerializedName("combination")  val combination_mpg: Int,
    @SerializedName("cylinders")  val cylinders: Int,
    @SerializedName("displacement")  val displacement: Double,
    @SerializedName("drive")  val drive: String,
    @SerializedName("fuel_type")   val fuel_type: String,
    @SerializedName("highway_mpg")  val highway_mpg: Int,
    @SerializedName("make")  val make: String,
    @SerializedName("model")   val model: String,
    @SerializedName("transmission")  val transmission: String,
    @SerializedName("year")  val year: Int,
    @SerializedName("favorite")val favorite: Boolean)
