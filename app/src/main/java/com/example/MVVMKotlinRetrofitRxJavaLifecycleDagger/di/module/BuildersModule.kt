package com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.di.module

import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.ui.CountryActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeCountryActivity(): CountryActivity
}