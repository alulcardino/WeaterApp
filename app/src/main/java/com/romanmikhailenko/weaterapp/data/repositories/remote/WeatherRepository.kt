package com.romanmikhailenko.weaterapp.data.repositories.remote

import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getWeather(latitude: Double, longitude: Double, unit: String) =
        apiService.getCurrentWeather(latitude, longitude, unit)

    suspend fun getForecast(latitude: Double, longitude: Double, unit: String) =
        apiService.getForecast(latitude, longitude, unit)
}