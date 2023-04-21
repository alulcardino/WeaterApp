package com.romanmikhailenko.weaterapp.data.api

import com.romanmikhailenko.weaterapp.utils.Constants.Companion.API_KEY
import retrofit2.http.Query

interface ApiService {

    suspend fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("units") unit: String,
        @Query("appid") appId: String = API_KEY
    )

    suspend fun getForecast(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("units") unit: String,
        @Query("appid") appId: String = API_KEY
    )
}