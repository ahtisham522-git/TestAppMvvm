package com.example.testapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.models.Facts
import com.example.testapp.repository.Factrepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FviewModel(private val repository:Factrepo):ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {   repository.getfacts()}

    }

    val facts:LiveData<Facts>
    get()=repository.facts


}