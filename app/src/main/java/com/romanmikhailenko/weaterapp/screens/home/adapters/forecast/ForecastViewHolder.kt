package com.romanmikhailenko.weaterapp.screens.home.adapters.forecast

import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.weaterapp.data.model.forecast.WeatherPerThreeHour
import com.romanmikhailenko.weaterapp.databinding.ItemForecastBinding
import com.romanmikhailenko.weaterapp.utils.TimeUtils

class ForecastViewHolder(
    private val binding: ItemForecastBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(forecast: WeatherPerThreeHour) {
        with(binding) {
            time.text = TimeUtils.getTime(forecast.dt.toLong())
            temp.text = forecast.main.temp.toString()
            desc.text = forecast.weather[0].description
        }
    }
}