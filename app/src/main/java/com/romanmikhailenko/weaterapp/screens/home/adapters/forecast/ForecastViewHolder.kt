package com.romanmikhailenko.weaterapp.screens.home.adapters.forecast

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.weaterapp.data.model.forecast.WeatherPerThreeHour
import com.romanmikhailenko.weaterapp.databinding.ItemForecastBinding
import com.romanmikhailenko.weaterapp.utils.Constants
import com.romanmikhailenko.weaterapp.utils.TimeUtils

class ForecastViewHolder(
    private val binding: ItemForecastBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(forecast: WeatherPerThreeHour) {
        with(binding) {
            val resID = binding.root.context.resources.getIdentifier(
                "${Constants.MAP_ICONS[forecast.weather[0].icon]}",
                "drawable", root.context.packageName)

            icon.setImageResource(resID)
            tvTime.text = TimeUtils.getDate(forecast.dt.toLong())
            tvTemp.text = "${forecast.main.temp.toInt()}°C"
            tvDesc.text = forecast.weather[0].description
        }
    }
}