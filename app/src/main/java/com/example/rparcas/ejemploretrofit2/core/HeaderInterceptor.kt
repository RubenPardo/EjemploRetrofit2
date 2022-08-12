package com.example.rparcas.ejemploretrofit2.core

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Clase interceptor de headers de las peticiones API REST
 * Este objeto se añadira a retrofit asi todas esas peticiones
 * tendran estas configuraciones en las cabeceras
 */
class HeaderInterceptor:Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Accept:","application/json")
            .build()

        return chain.proceed(request)
    }
}