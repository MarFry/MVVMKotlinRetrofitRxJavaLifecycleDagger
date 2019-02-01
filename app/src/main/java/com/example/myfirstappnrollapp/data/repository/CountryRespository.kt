package com.example.myfirstappnrollapp.data.repository

import androidx.lifecycle.ViewModel
import com.example.myfirstappnrollapp.data.model.Country
import com.example.myfirstappnrollapp.data.remote.ApiInterface
import io.reactivex.Observable
import javax.inject.Inject

class CountryRepository @Inject constructor(private val apiInterface: ApiInterface) : ViewModel() {

    fun getCountries(): Observable<List<Country>> {

        var singleFromApi: Observable<List<Country>>? = null

        singleFromApi = getCountriesFromApi()

        return singleFromApi
    }

    private fun getCountriesFromApi() =
        apiInterface.getCountryNameCurrenciesTopLevelDomainAndCallingCodes()
}