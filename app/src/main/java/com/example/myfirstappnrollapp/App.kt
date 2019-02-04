package com.example.myfirstappnrollapp

import android.app.Activity
import android.app.Application
import com.example.myfirstappnrollapp.di.component.DaggerAppComponent
import com.example.myfirstappnrollapp.di.module.AppModule
import com.example.myfirstappnrollapp.di.module.NetModule
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        inject()
        initLeakCanary()
    }

    private fun inject() {
        DaggerAppComponent.builder()
            .netModule(NetModule(BuildConfig.URL))
            .appModule(AppModule(this))
            .build()
            .inject(this)
    }

    private fun initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}