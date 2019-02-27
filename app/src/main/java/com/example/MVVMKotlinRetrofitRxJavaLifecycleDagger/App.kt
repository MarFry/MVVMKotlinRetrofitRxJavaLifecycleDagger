package com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger

import android.app.Activity
import android.app.Application
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.di.component.DaggerAppComponent
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.di.module.AppModule
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.di.module.DatabaseModule
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.di.module.NetModule
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
            .databaseModule(DatabaseModule())
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