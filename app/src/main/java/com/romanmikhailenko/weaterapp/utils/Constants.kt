package com.romanmikhailenko.weaterapp.utils

class Constants {
    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"
        const val API_KEY = "b26b1894f39b7044d74e09ab0ddf0fb1"
        const val DATABASE_NAME = "cityList.db"
        const val TABLE_CITY = "city_bd"
        val MAP_ICONS = mapOf(
            Pair("01d.png", "ic_clear_sky_d"),
            Pair("01n.png", "ic_clear_sky_n"),
            Pair("02d.png", "ic_few_clouds_d"),
            Pair("02n.png", "ic_few_clouds_n"),
            Pair("03d.png", "ic_scattered_clouds_d"),
            Pair("03n.png", "ic_scattered_clouds_n"),
            Pair("04d.png", "ic_broken_clouds_d"),
            Pair("04d.png", "ic_broken_clouds_n"),
            Pair("09d.png", "ic_shower_rain_d"),
            Pair("09n.png", "ic_shower_rain_n"),
            Pair("10d.png", "ic_rain_d.png"),
            Pair("10n.png", "ic_rain_n.png"),
            Pair("11d.png", "ic_thunderstorm_d"),
            Pair("11n.png", "ic_thunderstorm_n"),
            Pair("13d.png", "ic_snow_d.png"),
            Pair("13n.png", "ic_snow_n.png"),
            Pair("50d.png", "ic_mist_d.png"),
            Pair("50n.png", "ic_mist_n.png")
        )
    }
}