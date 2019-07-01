package com.example.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface UserApi {

    @GET("/users") //users here is the api call name www.hsbhsbchsdbcj/users
    suspend fun getUser():Response<List<User>> // data that is returning from our url
}