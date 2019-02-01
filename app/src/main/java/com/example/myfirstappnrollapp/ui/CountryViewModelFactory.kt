package com.example.myfirstappnrollapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class CountryViewModelFactory @Inject constructor(
    private val cryptoCurrencyViewModel: CountryViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountryViewModel::class.java)) {
            return cryptoCurrencyViewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}