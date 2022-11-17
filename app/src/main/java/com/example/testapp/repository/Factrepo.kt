package com.example.testapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testapp.api.ApiInterface
import com.example.testapp.models.Facts

class Factrepo (private val apiinterface:ApiInterface){

    private val factslivedata=MutableLiveData<Facts>()

    val facts:LiveData<Facts>
        get() =factslivedata


    suspend fun getfacts()
    {
        val result=apiinterface.getfacts()
        if(result.body()!=null)
        {
            factslivedata.postValue(result.body())
        }
    }
}