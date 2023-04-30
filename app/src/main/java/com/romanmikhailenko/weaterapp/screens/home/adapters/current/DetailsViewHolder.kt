package com.romanmikhailenko.weaterapp.screens.home.adapters.current

import com.romanmikhailenko.weaterapp.databinding.ItemWeatherDetailsBinding
import com.romanmikhailenko.weaterapp.screens.home.model.Details

class DetailsViewHolder(
    private val binding: ItemWeatherDetailsBinding
) : ViewHolderItem(binding.root) {
    fun bind(item: Details) = with(binding) {
        tvSunrise.text = item.sunrise
        tvSunset.text = item.sunset
        tvHumidity.text = item.humidity
        tvPressure.text = item.pressure
        tvVisibility.text = item.visibility
    }

}