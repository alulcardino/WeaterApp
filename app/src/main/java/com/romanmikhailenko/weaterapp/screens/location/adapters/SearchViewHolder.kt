package com.romanmikhailenko.weaterapp.screens.location.adapters

import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.weaterapp.data.model.city.City
import com.romanmikhailenko.weaterapp.databinding.ItemCityBinding

class SearchViewHolder(
    private val binding: ItemCityBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(city: City) {
        with(binding) {
            tvCityName.text = city.name
        }
    }
}