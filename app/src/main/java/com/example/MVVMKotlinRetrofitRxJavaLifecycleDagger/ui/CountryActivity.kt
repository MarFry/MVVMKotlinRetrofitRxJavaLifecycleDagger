package com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.ui


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.R
import com.example.MVVMKotlinRetrofitRxJavaLifecycleDagger.data.model.Country
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_country.*
import javax.inject.Inject

class CountryActivity : AppCompatActivity() {

    @Inject
    lateinit var countryViewModelFactory: CountryViewModelFactory
    private val countryAdapter = CountryAdapter(ArrayList())
    private lateinit var countryViewModel: CountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)
        AndroidInjection.inject(this)

        countryViewModel = ViewModelProviders.of(this, countryViewModelFactory)
            .get(CountryViewModel::class.java)

        initRecyclerView()
        loadData()
        loadDataResult()
        loadDataError()
        loadDataLoader()
    }

    private fun initRecyclerView() {
        val gridLayoutManager = GridLayoutManager(this, 2)
        gridLayoutManager.orientation = RecyclerView.VERTICAL
        countryRecyclerView.apply {
            layoutManager = gridLayoutManager
        }

    }

    private fun loadData() {
        countryViewModel.loadCountries()
    }

    private fun loadDataResult() {
        countryViewModel.countriesResult().observe(this,
            Observer<List<Country>> {
                if (it != null) {
                    countryAdapter.setItems(it)
                    countryRecyclerView.adapter = countryAdapter
                }
            })
    }

    private fun loadDataError() {
        countryViewModel.countriesError().observe(this,
            Observer<String> {
                if (it != null) {

                }
            })
    }

    private fun loadDataLoader() {
        countryViewModel.countriesLoader().observe(this,
            Observer<Boolean> {
                if (!it) progressBar.visibility = View.GONE
            }
        )
    }

    override fun onDestroy() {
        countryViewModel.disposeElements()
        super.onDestroy()
    }
}
