package com.example.rparcas.ejemploretrofit2.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rparcas.ejemploretrofit2.domain.DogsResponseItem
import com.example.rparcas.ejemploretrofit2.domain.SearchDogsByNameUseCase
//import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
//import javax.inject.Inject

//@HiltViewModel
class DogsViewModel /*@Inject constructor(
    private val searchDogsByNameUseCase: SearchDogsByNameUseCase
)*/:ViewModel() {

    private val searchDogsByNameUseCase = SearchDogsByNameUseCase()

    val isLoading = MutableLiveData<Boolean>()
    val dogsImages = MutableLiveData<List<String>>()
    val error = MutableLiveData<String>()

    fun onCreate(){
        isLoading.postValue(false)
        dogsImages.postValue(listOf())
    }

    fun searchDogsByName(name:String){
        viewModelScope.launch {
            isLoading.postValue(true)
            val dogsResponseItem = searchDogsByNameUseCase(name)
            if(dogsResponseItem.status == "success"){
                dogsImages.postValue(dogsResponseItem.images)
            }else{
                error.postValue("Ha ocurrido un error")
            }
            isLoading.postValue(false)

        }
    }

}