package com.example.rparcas.ejemploretrofit2.data.network

import com.example.rparcas.ejemploretrofit2.data.model.DogsResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface DogApiClient {

    /**
     * Peticion get para obtener fotos de una raza de perros
     * @param url es el perro que queremos pedir, es decir hay una url fija https://dog.ceo/api/breed/ y esta url tiene que ser hound, akita, etc..
     * @return Un objeto [DogsResponseModel] con la lista de imagenes
     */
    @GET
    suspend fun getDogsByBreeds(@Url url:String): Response<DogsResponseModel>
}