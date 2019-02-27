package com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.features

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.model.Country
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.remote.ApiInterface
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.repository.CountryRepository
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.persistence.dao.CountryDao
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.utils.NetworkUtils
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.utils.RxImmediateSchedulerRule
import io.reactivex.Flowable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.BDDMockito.*

@RunWith(JUnit4::class)
class CountryRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    var rxImmediateSchedulerRule = RxImmediateSchedulerRule()

    private val apiInterface = mock(ApiInterface::class.java)
    private val countryDao = mock(CountryDao::class.java)
    private val networkUtils = mock(NetworkUtils::class.java)
    private val countryRepository = CountryRepository(apiInterface, countryDao, networkUtils)
    @Before
    fun setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

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

    @Test
    fun verifySavingCountriesToDatabaseAfterApiInterfaceInteraction() {
//        val countries = mutableListOf<Country>()
//        val currencies = listOf(Currency("code", "name", "symbol"))
//        val domains = listOf(".pl")
//        val callingCodes = listOf("codes")
//        countries.add(Country("s", currencies, domains, callingCodes))
//
//        `when`(apiInterface.getCountryNameCurrenciesTopLevelDomainAndCallingCodes()).thenReturn(
//            Flowable.just(countries)
//        )
//        given(apiInterface.getCountryNameCurrenciesTopLevelDomainAndCallingCodes().doOnNext { countryDao.insertAllCountries(countries)
//        }).willReturn(Flowable.just(countries))
//        countryRepository.getCountriesFromApi()
//
//        verify(countryDao).insertAllCountries(countries)
    }
}

