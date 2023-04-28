package com.romanmikhailenko.weaterapp.data.repositories.remote

import com.romanmikhailenko.weaterapp.data.model.current.WeatherResponse
import com.romanmikhailenko.weaterapp.data.model.forecast.ForecastResponse
import com.romanmikhailenko.weaterapp.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("lat") latitude: Double = 44.34,
        @Query("lon") longitude: Double = 10.99,
        @Query("units") unit: String = "metrical",
        @Query("appid") appId: String = API_KEY
    ): Response<WeatherResponse>

    @GET("/data/2.5/forecast")
    suspend fun getForecast(
        @Query("lat") latitude: Double = 44.34,
        @Query("lon") longitude: Double = 10.99,
        @Query("units") unit: String = "metrical",
        @Query("appid") appId: String = API_KEY
    ): Response<ForecastResponse>

}