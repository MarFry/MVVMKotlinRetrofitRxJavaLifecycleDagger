package com.example.myfirstappnrollapp.di.module

import android.app.Application
import androidx.room.Room
import com.example.myfirstappnrollapp.BuildConfig
import com.example.myfirstappnrollapp.persistence.dao.CountryDao
import com.example.myfirstappnrollapp.persistence.local.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule{

    @Provides
    @Singleton
    fun provideCountryDatabase(app: Application) : Database
    = Room.databaseBuilder(app, Database::class.java, BuildConfig.DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideCountryDao(database: Database) : CountryDao = database.countryDao()
}