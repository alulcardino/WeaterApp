package com.romanmikhailenko.weaterapp.data.api

import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getWeather(latitude: Double, longitude: Double, unit: String) =
        apiService.getCurrentWeather(latitude, longitude, unit)
}