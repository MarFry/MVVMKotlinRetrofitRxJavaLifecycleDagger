package com.example.myfirstappnrollapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myfirstappnrollapp.data.model.Country
import com.example.myfirstappnrollapp.data.repository.CountryRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import javax.inject.Inject

class CountryViewModel @Inject constructor(private val countryRepository: CountryRepository, application : Application) : AndroidViewModel(application) {

    var countriesResult: MutableLiveData<List<Country>> = MutableLiveData()
    var countriesError: MutableLiveData<String> = MutableLiveData()
    var countriesLoader: MutableLiveData<Boolean> = MutableLiveData()
    private lateinit var resourceSubscriber: ResourceSubscriber<List<Country>>

    fun countriesResult(): LiveData<List<Country>> {
        return countriesResult
    }

    fun countriesError(): LiveData<String> {
        return countriesError
    }

    fun countriesLoader(): LiveData<Boolean> {
        return countriesLoader
    }

    fun loadCountries() {

        resourceSubscriber = object : ResourceSubscriber<List<Country>>() {
            override fun onComplete() {

            }

            override fun onNext(countires: List<Country>) {
                countriesResult.postValue(countires)
                countriesLoader.postValue(false)
            }

            override fun onError(e: Throwable) {
                countriesError.postValue(e.message)
                countriesLoader.postValue(false)
            }
        }

        countryRepository.getCountries()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(resourceSubscriber)

    }

    fun disposeElements() {
        if (!resourceSubscriber.isDisposed) resourceSubscriber.dispose()
    }
}