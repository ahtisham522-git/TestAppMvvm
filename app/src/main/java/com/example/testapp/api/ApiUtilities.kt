package com.example.testapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilities {
    val Url="https://catfact.ninja/"

    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Url).addConverterFactory(GsonConverterFactory
                .create())
            .build()
    }
}