package com.example.myfirstappnrollapp.di.module

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.myfirstappnrollapp.ui.CountryViewModelFactory
import com.example.myfirstappnrollapp.utils.NetworkUtils
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
    fun provideCountryViewModelFactory(factory : CountryViewModelFactory): ViewModelProvider.Factory = factory

    @Provides
    @Singleton
    fun provideNetworkUtils() : NetworkUtils = NetworkUtils(app)
}