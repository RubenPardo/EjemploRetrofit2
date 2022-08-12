package com.example.rparcas.ejemploretrofit2.domain

import android.util.Log
import com.example.rparcas.ejemploretrofit2.data.DogsRepository
//import javax.inject.Inject

class SearchDogsByNameUseCase /*@Inject constructor(private val repository:DogsRepository)*/ {

    private val repository = DogsRepository()

    suspend operator fun invoke(name:String):DogsResponseItem{
        val dogsResponse:DogsResponseItem = repository.searchDogsByNameFromApi(name)

        return dogsResponse

    }

}