package com.romanmikhailenko.weaterapp.utils

class Constants {
    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"
        const val API_KEY = "b26b1894f39b7044d74e09ab0ddf0fb1"
        const val DATABASE_NAME = "cityList.db"
        const val TABLE_CITY = "city_bd"
        val MAP_ICONS = mapOf(
            Pair("01d", "ic_clear_sky_d"),
            Pair("01n", "ic_clear_sky_n"),
            Pair("02d", "ic_few_clouds_d"),
            Pair("02n", "ic_few_clouds_n"),
            Pair("03d", "ic_scattered_clouds_d"),
            Pair("03n", "ic_scattered_clouds_n"),
            Pair("04d", "ic_broken_clouds_d"),
            Pair("04n", "ic_broken_clouds_n"),
            Pair("09d", "ic_shower_rain_d"),
            Pair("09n", "ic_shower_rain_n"),
            Pair("10d", "ic_rain_d"),
            Pair("10n", "ic_rain_n"),
            Pair("11d", "ic_thunderstorm_d"),
            Pair("11n", "ic_thunderstorm_n"),
            Pair("13d", "ic_snow_d"),
            Pair("13n", "ic_snow_n"),
            Pair("50d", "ic_mist_d"),
            Pair("50n", "ic_mist_n")
        )
    }
}