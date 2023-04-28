package com.romanmikhailenko.weaterapp.data.model.forecast

data class ForecastResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<WeatherPerThreeHour>,
    val message: Int
)