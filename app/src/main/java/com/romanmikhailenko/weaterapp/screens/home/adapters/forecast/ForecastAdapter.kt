package com.romanmikhailenko.weaterapp.screens.home.adapters.forecast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.weaterapp.data.model.forecast.WeatherPerThreeHour
import com.romanmikhailenko.weaterapp.databinding.ItemForecastBinding

class ForecastAdapter : RecyclerView.Adapter<ForecastViewHolder>() {

    var forecast = listOf<WeatherPerThreeHour>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(
            ItemForecastBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(forecast[position])
    }

    override fun getItemCount() = forecast.size

    fun setItems(newItems: List<WeatherPerThreeHour>) {
        forecast = newItems.toList()
        notifyDataSetChanged()
    }
}