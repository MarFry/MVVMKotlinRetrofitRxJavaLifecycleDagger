package com.example.myfirstappnrollapp.persistence.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myfirstappnrollapp.data.model.Country
import com.example.myfirstappnrollapp.persistence.conventer.CurrencyConverter
import com.example.myfirstappnrollapp.persistence.conventer.StringConverter
import com.example.myfirstappnrollapp.persistence.dao.CountryDao

@Database(entities = [(Country::class)], version = 1, exportSchema = false)
@TypeConverters(CurrencyConverter::class, StringConverter::class)
abstract class Database : RoomDatabase() {
    abstract fun countryDao() : CountryDao
}