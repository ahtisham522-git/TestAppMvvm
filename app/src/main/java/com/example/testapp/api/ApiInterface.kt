package com.example.testapp.api

import com.example.testapp.models.Facts
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/fact")
    suspend fun getfacts(): Response <Facts>
}