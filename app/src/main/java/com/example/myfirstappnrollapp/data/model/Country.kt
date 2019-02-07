package com.example.myfirstappnrollapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "countries"
)
data class Country(
    @PrimaryKey
    val name: String,
    val currencies: List<Currency>,
    val topLevelDomain: List<String>,
    val callingCodes: List<String>
)