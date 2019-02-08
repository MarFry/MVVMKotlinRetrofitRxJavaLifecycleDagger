package com.example.myfirstappnrollapp.data.repository

import com.example.myfirstappnrollapp.data.model.Country
import io.reactivex.Flowable

interface CountryRepositoryInterface {

    fun getCountries(): Flowable<List<Country>>
    fun getCountriesFromApi(): Flowable<List<Country>>
    fun getCountriesFromDatabase(): Flowable<List<Country>>
    fun saveCountriesToDatabase(countries: List<Country>)
}