package ar.edu.ort.tpapp.core

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

object InterceptorCustom: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        Log.i("InterceptorCustom", "intercept(Interceptor.Chain) - in")
        var apiKey= Config.apiKey
        var request= chain.request()

        request= request.newBuilder()
            .header("X-Api-Key", apiKey?:"")
            .header("Accept","application/json")
            .header("Content-Type", "application/json")
            .build()

        Log.i("InterceptorCustom", "intercept(Interceptor.Chain) - out")
        return chain.proceed(request)
    }
}