package com.example.rparcas.ejemploretrofit2.data.model

import com.google.gson.annotations.SerializedName

/**
 * DogsResponse va a tener como parametros los atributos que recibe por API
 */
data class DogsResponseModel(
    @SerializedName("status") var status: String,
    @SerializedName("message") var images: List<String>
)
