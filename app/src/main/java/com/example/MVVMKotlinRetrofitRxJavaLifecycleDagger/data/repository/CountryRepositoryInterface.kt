package com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.repository

import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.model.Country
import io.reactivex.Flowable

interface CountryRepositoryInterface {

    fun getCountries(): Flowable<List<Country>>
    fun getCountriesFromApi(): Flowable<List<Country>>
    fun getCountriesFromDatabase(): Flowable<List<Country>>
}