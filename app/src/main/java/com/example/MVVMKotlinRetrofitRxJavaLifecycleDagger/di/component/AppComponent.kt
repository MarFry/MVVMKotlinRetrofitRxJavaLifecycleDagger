package com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.di.component

import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.App
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.di.module.AppModule
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.di.module.BuildersModule
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.di.module.DatabaseModule
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.di.module.NetModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [(NetModule::class), (BuildersModule::class), (AppModule::class), (DatabaseModule::class)]
)
interface AppComponent {
    fun inject(app: App)
}