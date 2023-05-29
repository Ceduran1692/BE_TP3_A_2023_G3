package ar.edu.ort.tpapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ar.edu.ort.tpapp.data.database.entities.CarEntity

@Dao
interface CarDao {

    @Query("SELECT * FROM car_table ORDER BY id DESC")
    suspend fun getAllCars():List<CarEntity>

    @Query("SELECT * FROM car_table WHERE make LIKE (:brand) ORDER BY id DESC")
    suspend fun getAllCarsByBrand(brand:String):List<CarEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cars:List<CarEntity>)

    @Query("DELETE FROM car_table WHERE favorite = 0 ")
    suspend fun deleteNonFavoriteCars()

}