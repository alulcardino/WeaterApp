package com.romanmikhailenko.weaterapp.screens.location.adapters

import android.app.ActivityOptions
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Pair
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.weaterapp.data.model.city.City
import com.romanmikhailenko.weaterapp.databinding.ItemCityBinding
import com.romanmikhailenko.weaterapp.databinding.ItemSavedCityBinding

class CitiesViewHolder(
    private val binding: ItemSavedCityBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(city: City) {
        with(binding) {
            tvCityTemp.text = city.name
            tvCountryNameSearch.text = city.country
        }
    }


}