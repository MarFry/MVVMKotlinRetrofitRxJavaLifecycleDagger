package com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.repository

import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.model.Country
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.remote.ApiInterface
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.persistence.dao.CountryDao
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.utils.NetworkUtils
import io.reactivex.Flowable
import javax.inject.Inject

class CountryRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val countryDao: CountryDao, private val networkUtils: NetworkUtils
) : CountryRepositoryInterface {

    override fun getCountries(): Flowable<List<Country>> {
        val isConnected = networkUtils.isNetworkAvailable()
        var flowableFromApi: Flowable<List<Country>>? = null

        if (isConnected)
            flowableFromApi = getCountriesFromApi()

        val flowableFromDatabase = getCountriesFromDatabase()

        return if (isConnected) Flowable.concatArrayEager(flowableFromApi, flowableFromDatabase)
        else flowableFromDatabase
    }

    override fun getCountriesFromDatabase(): Flowable<List<Country>> = countryDao.getCountries()

    override fun getCountriesFromApi() =
        apiInterface.getCountryNameCurrenciesTopLevelDomainAndCallingCodes()
            .doOnNext {
                countryDao.insertAllCountries(it)
            }!!
}