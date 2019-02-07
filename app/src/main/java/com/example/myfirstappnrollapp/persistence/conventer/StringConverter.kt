package com.example.myfirstappnrollapp.persistence.conventer

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class StringConverter {
    @TypeConverter
    fun listToJson(value: List<String>?): String {
        val moshi = Moshi.Builder().build()
        val listType = Types.newParameterizedType(
            List::class.java,
            String::class.java
        )
        val jsonAdapter: JsonAdapter<List<String>> = moshi.adapter(listType)
        return jsonAdapter.toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<String>? {
        val moshi = Moshi.Builder().build()
        val listType = Types.newParameterizedType(
            List::class.java,
            String::class.java
        )
        val jsonAdapter: JsonAdapter<List<String>> = moshi.adapter(listType)
        return jsonAdapter.fromJson(value)
    }
}