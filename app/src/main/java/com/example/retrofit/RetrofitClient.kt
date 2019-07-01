package com.example.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
// HERE WE ARE CREAING AN OBJECT OF OUR RETROFIT

object RetrofitClient {
    val userApi = retrofit().create(UserApi::class.java) //"BUILDING OUR API"  create method takes our UserApi interface , basically combining our retrofit and UserApi

    private fun retrofit() = Retrofit.Builder()//conveninet builder for creating our required object.
        .baseUrl("https://jsonplaceholder.typicode.com")//url which is going to be used for evry function call
        .addConverterFactory(GsonConverterFactory.create()) //convertor factory takes care of parsing of the data
        .build()
}