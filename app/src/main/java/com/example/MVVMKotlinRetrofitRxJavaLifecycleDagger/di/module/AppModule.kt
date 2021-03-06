package com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.di.module

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.remote.ApiInterface
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.repository.CountryRepository
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.repository.CountryRepositoryInterface
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.persistence.dao.CountryDao
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.ui.CountryViewModelFactory
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.utils.NetworkUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {
    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideCountryViewModelFactory(factory: CountryViewModelFactory): ViewModelProvider.Factory = factory

    @Provides
    @Singleton
    fun provideCountryRepositoryInterface(
        apiInterface: ApiInterface,
        networkUtils: NetworkUtils,
        countryDao: CountryDao
    ): CountryRepositoryInterface = CountryRepository(apiInterface, countryDao, networkUtils)

    @Provides
    @Singleton
    fun provideNetworkUtils(): NetworkUtils = NetworkUtils(app)
}