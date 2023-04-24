package com.romanmikhailenko.weaterapp.screens.home.model

data class MainInfo(
    val temp: String,
    val feelsLike: String,
    val icon: String,
    val description: String
) : Item
