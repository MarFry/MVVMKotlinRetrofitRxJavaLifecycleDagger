package com.example.myfirstappnrollapp.utils

import org.mockito.Mockito

inline fun <reified T> mock(): T = Mockito.mock(T::class.java)

//inline fun <reified T> doOnNext(countries: T) = Flowable(T::class.java)


