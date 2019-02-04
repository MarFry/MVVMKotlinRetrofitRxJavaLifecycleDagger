package com.example.myfirstappnrollapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstappnrollapp.R
import com.example.myfirstappnrollapp.data.model.Country


class CountryAdapter(countries: List<Country>) : RecyclerView.Adapter<CountryViewHolder>() {

    private var countryList = ArrayList<Country>()

    init {
        this.countryList = countries as ArrayList<Country>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_view_country_item,
            parent, false
        )
        return CountryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]
        holder.setUI(country)
    }

    fun setItems(countryList : List<Country>){
        this.countryList.addAll(countryList)
    }
}


class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var countryName = itemView.findViewById<TextView>(R.id.countryNameTextView)

    fun setUI(country: Country) {
        countryName.text = country.name
    }
}