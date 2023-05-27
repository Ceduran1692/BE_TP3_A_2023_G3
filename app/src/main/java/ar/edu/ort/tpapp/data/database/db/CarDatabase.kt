package ar.edu.ort.tpapp.data.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ar.edu.ort.tpapp.data.database.dao.CarDao
import ar.edu.ort.tpapp.data.database.entities.CarEntity

@Database(entities = [CarEntity::class], version = 2)
abstract class CarDatabase:RoomDatabase() {

    abstract fun getCarDao():CarDao
}