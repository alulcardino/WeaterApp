package com.romanmikhailenko.weaterapp.screens.home.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.weaterapp.databinding.ItemWeatherDetailsBinding
import com.romanmikhailenko.weaterapp.screens.home.model.Details

class DetailsViewHolder(
    private val binding: ItemWeatherDetailsBinding
) : ViewHolderItem(binding.root) {
    fun bind(item: Details) = with(binding) {
        tvHumidity.text = item.humidity
        tvSunrise.text = item.sunrise
        tvSunset.text = item.sunset
        tvPressure.text = item.pressure
        tvVisibility.text = item.visibility
    }

}