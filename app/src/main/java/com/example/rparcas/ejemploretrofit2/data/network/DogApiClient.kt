package com.example.rparcas.ejemploretrofit2.data.network

import com.example.rparcas.ejemploretrofit2.data.model.DogsResponseModel
import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface DogApiClient {

    /**
     * Peticion get para obtener fotos de una raza de perros
     * @param url es el perro que queremos pedir, es decir hay una url fija https://dog.ceo/api/breed/ y esta url tiene que ser hound, akita, etc..
     * @return Un objeto [DogsResponseModel] con la lista de imagenes
     */
    @GET
    suspend fun getDogsByBreeds(@Url url:String): Response<DogsResponseModel>

    /**
     * De esta forma podemos hacer que el endpoint tenga variables y no lo hardcodeemos
     */
    @GET("ejemplo/v2/{id}/objetos")
    suspend fun getEjemploConParametros(@Path("id") id:String): Response<DogsResponseModel>

    /**
     * Para cuando la peticion api es del siguiente estilo
     *
     * ejemplo/v2/objetos&param1={param1}&param2={param2}
     */
    @GET("ejemplo/v2/objetos")
    suspend fun getEjemploQuery(@Query("param1")param1:String, @Query("param2")param2:String): Response<DogsResponseModel>


    @POST
    suspend fun postEjemplo(@Body objeto:ObjetoEjemploDTO):Response<*>


    @Multipart // con esta etiqueta le indicamos que trocee la peticion
    @POST
    suspend fun postEjemploImagen(@Part image:MultipartBody.Part):Response<*>

    // convertir fichero en multipartbody
    // val requestBodu = RequestBody.create(MediaType.parse(getContentResolver().getType(file.getUri()),file)
    // val a = MultiPartBody.Part.createFormData("picture", file.getName(), requestBody);
}

/**
 * Objeto de ejemplo para el body
 * DTO = data transfer object
 */
data class ObjetoEjemploDTO(@SerializedName("ejemplo")val ejemplo:String)