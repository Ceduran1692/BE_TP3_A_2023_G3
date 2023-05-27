package ar.edu.ort.tpapp.di

import android.content.Context
import androidx.room.Room
import ar.edu.ort.tpapp.data.database.db.CarDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val CARS_DATABASE_NAME= "cars_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context)=
        Room.databaseBuilder(context,CarDatabase::class.java, CARS_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideCarDao(db:CarDatabase)= db.getCarDao()
}