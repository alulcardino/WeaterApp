package com.romanmikhailenko.weaterapp.screens.cities.adapters

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
            binding.tvCityTemp.text = tvCityTemp.text
            binding.tvCountryNameSearch.text = tvCityTemp.text
        }
    }


}