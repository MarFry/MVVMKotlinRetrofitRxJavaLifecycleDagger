package com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.features

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.App
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.repository.CountryRepository
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.ui.CountryViewModel
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.utils.mock
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


@RunWith(JUnit4::class)
class CountryViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val countryRepositoryInterface = mock(CountryRepository::class.java)
    private val app = mock(App::class.java)
    private val countryViewModel = CountryViewModel(countryRepositoryInterface, app)

    @Test
    fun loadCountries() {
        countryViewModel.countriesResult.observeForever(mock())
        countryViewModel.loadCountries()
        verify(countryRepositoryInterface).getCountries()
    }


}