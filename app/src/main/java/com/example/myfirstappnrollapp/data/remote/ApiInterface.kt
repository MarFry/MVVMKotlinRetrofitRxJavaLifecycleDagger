package com.example.myfirstappnrollapp.data.remote

import com.example.myfirstappnrollapp.data.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    //https://restcountries.eu/rest/v2/all?fields=name;currencies;topLevelDomain;callingCodes

    @GET("all?fields=name;currencies;topLevelDomain;callingCodes")
    fun getCountryNameCurrienciesTopLevelDomainAndCallingCodes() : Single<List<Country>>
}