package com.example.rparcas.ejemploretrofit2.domain

import com.example.rparcas.ejemploretrofit2.data.model.DogsResponseModel

data class DogsResponseItem(val status:String,val images:List<String>)

fun DogsResponseModel.toDomain() = DogsResponseItem(status,images)