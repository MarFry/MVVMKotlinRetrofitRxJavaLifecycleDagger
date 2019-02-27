package com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.persistence.conventer

import androidx.room.TypeConverter
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.model.Currency
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class CurrencyConverter {
    @TypeConverter
    fun listToJson(value: List<Currency>?): String {
        val moshi = Moshi.Builder().build()
        val listType = Types.newParameterizedType(
            List::class.java,
            Currency::class.java
        )
        val adapter: JsonAdapter<List<Currency>> = moshi.adapter(listType)
        return adapter.toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<Currency>? {
        val moshi = Moshi.Builder().build()
        val listType = Types.newParameterizedType(
            List::class.java,
            Currency::class.java
        )
        val adapter: JsonAdapter<List<Currency>> = moshi.adapter(listType)
        return adapter.fromJson(value) //Expected BEGIN_ARRAY but was BEGIN_OBJECT at path $[0]
    }
}