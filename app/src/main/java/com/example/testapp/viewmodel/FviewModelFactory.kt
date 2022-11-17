package com.example.testapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.repository.Factrepo

class FviewModelFactory(private val frepoistory:Factrepo):ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FviewModel(frepoistory) as T
    }

}