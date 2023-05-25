package ar.edu.ort.tpapp.data.database.entities

data class CarsEntity(val city_mpg: Int,
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
                      val favorite: Boolean)
