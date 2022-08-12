package com.example.rparcas.ejemploretrofit2.data.network

import android.util.Log
import com.example.rparcas.ejemploretrofit2.core.RetrofitHelper
import com.example.rparcas.ejemploretrofit2.data.model.DogsResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class DogsService @Inject constructor(private val api:DogApiClient) {



    suspend fun searchDogByName(name:String): DogsResponseModel {
        return withContext(Dispatchers.IO){
            val response : Response<DogsResponseModel> = api.getDogsByBreeds(name)
            /*val response: Response<DogsResponseModel> =
                retrofit.create(DogApiClient::class.java).getDogsByBreeds(name)*/
            response.body() ?: DogsResponseModel("", listOf())

        }
    }

}