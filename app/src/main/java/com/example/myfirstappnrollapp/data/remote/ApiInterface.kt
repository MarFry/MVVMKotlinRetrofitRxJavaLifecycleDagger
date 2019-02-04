package com.example.myfirstappnrollapp.data.remote

import com.example.myfirstappnrollapp.data.model.Country
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleObserver
import retrofit2.http.GET

interface ApiInterface {

    @GET("all?fields=name;currencies;topLevelDomain;callingCodes")
    fun getCountryNameCurrenciesTopLevelDomainAndCallingCodes() : Flowable<List<Country>>
}