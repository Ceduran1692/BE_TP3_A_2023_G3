package ar.edu.ort.tpapp

import android.app.Application
import android.util.Log
import ar.edu.ort.tpapp.core.Config
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppContext:Application() {
    override fun onCreate() {
        super.onCreate()

        Config.apiKey= resources.getString(R.string.api_key)
        Config.baseUrl= resources.getString(R.string.base_url)
        Config.brands= arrayOf("mercedes-benz","maserati","toyota","porsche","volkswagen","renault","renault","bmw","audi")

        Log.i("AppContext","cargando datos:" +
                " apiKey: "+Config.apiKey+", baseUrl: "+Config.baseUrl)
    }
}