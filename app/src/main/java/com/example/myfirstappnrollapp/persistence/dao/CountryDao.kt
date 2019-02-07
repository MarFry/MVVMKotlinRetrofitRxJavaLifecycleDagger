package com.example.myfirstappnrollapp.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myfirstappnrollapp.data.model.Country
import io.reactivex.Flowable

@Dao
interface CountryDao {

    @Query("SELECT * FROM countries")
    fun getCountries(): Flowable<List<Country>>

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    fun insertAllCountries(countries: List<Country>)
}