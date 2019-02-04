package com.example.myfirstappnrollapp.data.repository
import com.example.myfirstappnrollapp.data.model.Country
import com.example.myfirstappnrollapp.data.remote.ApiInterface
import io.reactivex.Flowable
import javax.inject.Inject

class CountryRepository @Inject constructor(private val apiInterface: ApiInterface)  {

    fun getCountries(): Flowable<List<Country>> {

        val singleFromApi: Flowable<List<Country>>?

        singleFromApi = getCountriesFromApi()

        return singleFromApi
    }

    private fun getCountriesFromApi() =
        apiInterface.getCountryNameCurrenciesTopLevelDomainAndCallingCodes()
}