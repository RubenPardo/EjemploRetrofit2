package com.example.rparcas.ejemploretrofit2.data

import android.util.Log
import com.example.rparcas.ejemploretrofit2.data.model.DogsResponseModel
import com.example.rparcas.ejemploretrofit2.data.network.DogsService
import com.example.rparcas.ejemploretrofit2.domain.DogsResponseItem
import com.example.rparcas.ejemploretrofit2.domain.toDomain
//import javax.inject.Inject

class DogsRepository /*@Inject constructor(
    private val api:DogsService)*/ {

    private val api = DogsService()

    suspend fun searchDogsByNameFromApi(name: String): DogsResponseItem {
        val response:DogsResponseModel = api.searchDogByName("$name/images")
        return response.toDomain()

    }
}