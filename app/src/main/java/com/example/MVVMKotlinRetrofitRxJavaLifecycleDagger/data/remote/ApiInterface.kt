package com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.remote

import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.model.Country
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiInterface {

    @GET("all?fields=name;currencies;topLevelDomain;callingCodes")
    fun getCountryNameCurrenciesTopLevelDomainAndCallingCodes() : Flowable<List<Country>>
}