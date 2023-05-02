package com.romanmikhailenko.weaterapp.screens.home.model

data class MainInfo(
    val temp: String,
    val icon: String,
    val description: String,
    val city: String
) : Item
