package com.example.myfirstappnrollapp.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myfirstappnrollapp.R
import com.example.myfirstappnrollapp.data.model.Country
import dagger.android.AndroidInjection
import javax.inject.Inject

class CountryActivity : AppCompatActivity() {

    @Inject
    lateinit var countryViewModelFactory: CountryViewModelFactory
    private lateinit var countryViewModel: CountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)
        AndroidInjection.inject(this)

        countryViewModel = ViewModelProviders.of(this, countryViewModelFactory)
            .get(CountryViewModel::class.java)

        loadData()

        loadDataResult()
        loadDataError()
    }

    private fun loadData() {
        countryViewModel.loadCountries()
    }

    private fun loadDataResult() {
        countryViewModel.countriesResult().observe(this,
            Observer<List<Country>> {
                if (it != null) {

                }
            })
    }

    private fun loadDataError() {
        countryViewModel.countriesError().observe(this,
            Observer<String> {
                if(it != null){

                }

            })
    }
}
