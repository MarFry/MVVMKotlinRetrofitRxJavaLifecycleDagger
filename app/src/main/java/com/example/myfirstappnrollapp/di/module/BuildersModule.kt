package com.example.myfirstappnrollapp.di.module

import com.example.myfirstappnrollapp.ui.CountryActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeCountryActivity(): CountryActivity
}