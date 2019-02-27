package com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.persistence.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.model.Country
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.persistence.conventer.CurrencyConverter
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.persistence.conventer.StringConverter
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.persistence.dao.CountryDao

@Database(entities = [(Country::class)], version = 1, exportSchema = false)
@TypeConverters(CurrencyConverter::class, StringConverter::class)
abstract class Database : RoomDatabase() {
    abstract fun countryDao() : CountryDao
}