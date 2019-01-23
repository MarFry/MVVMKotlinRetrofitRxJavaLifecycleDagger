package com.example.myfirstappnrollapp.data.model


data class Country(
    val name: String,
    val currencies: List<Currency>,
    val topLevelDomain: List<String>,
    val callingCodes: List<String>
)