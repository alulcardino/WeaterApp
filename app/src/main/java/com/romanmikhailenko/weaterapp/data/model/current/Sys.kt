package com.romanmikhailenko.weaterapp.data.model.current

data class Sys(
    val country: String,
    val id: Int,
    val sunrise: Long,
    val sunset: Long,
    val type: Int
)