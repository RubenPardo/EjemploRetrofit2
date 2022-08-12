package com.example.rparcas.ejemploretrofit2.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * NO SE USA AHORA MISMO
 * ESTA EN EL DIRECTORIO DI/NETWORKMODULE.kt
 */
object RetrofitHelper {
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}