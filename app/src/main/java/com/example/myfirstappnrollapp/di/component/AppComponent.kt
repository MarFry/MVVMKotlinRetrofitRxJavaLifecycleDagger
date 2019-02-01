package com.example.myfirstappnrollapp.di.component

import com.example.myfirstappnrollapp.App
import com.example.myfirstappnrollapp.di.module.AppModule
import com.example.myfirstappnrollapp.di.module.BuildersModule
import com.example.myfirstappnrollapp.di.module.NetModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [(NetModule::class), (BuildersModule::class), (AppModule::class)]
)
interface AppComponent {
    fun inject(app: App)
}