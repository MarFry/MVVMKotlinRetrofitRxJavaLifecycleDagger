package com.example.myfirstappnrollapp.features

import com.example.myfirstappnrollapp.data.model.Country
import com.example.myfirstappnrollapp.data.remote.ApiInterface
import com.example.myfirstappnrollapp.data.repository.CountryRepository
import com.example.myfirstappnrollapp.persistence.dao.CountryDao
import com.example.myfirstappnrollapp.utils.NetworkUtils
import com.example.myfirstappnrollapp.utils.RxImmediateSchedulerRule
import io.reactivex.Flowable
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.BDDMockito.*

@RunWith(JUnit4::class)
class CountryRepositoryTest {

    private val apiInterface = mock(ApiInterface::class.java)
    private val countryDao = mock(CountryDao::class.java)
    private val networkUtils = mock(NetworkUtils::class.java)
    private val countryRepository = CountryRepository(apiInterface, countryDao, networkUtils)

    @Test
    fun verifyApiInterfaceInteractionWhenNetworkAvailable() {
        val countries = listOf<Country>()
        `when`(networkUtils.isNetworkAvailable()).thenReturn(true)
        `when`(apiInterface.getCountryNameCurrenciesTopLevelDomainAndCallingCodes()).thenReturn(
            Flowable.just(
                countries
            )
        )
        countryRepository.getCountries()
        verify(apiInterface).getCountryNameCurrenciesTopLevelDomainAndCallingCodes()
    }

    @Test
    fun verifyCountryDaoInteractionWhenNetworkUnavailable() {
        countryRepository.getCountries()
        verify(countryDao).getCountries()
    }
}

