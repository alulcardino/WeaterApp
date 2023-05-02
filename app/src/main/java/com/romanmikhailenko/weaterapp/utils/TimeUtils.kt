package com.romanmikhailenko.weaterapp.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object TimeUtils {
    @SuppressLint("SimpleDateFormat")
    private val timeFormatter = SimpleDateFormat("HH:mm")
    @SuppressLint("SimpleDateFormat")
    private val dateFormatter = SimpleDateFormat("dd.MM HH:mm")

    fun getTime(timeInMillis : Long): String {
        val cv = Calendar.getInstance()
        timeFormatter.timeZone = TimeZone.getDefault()
        cv.timeInMillis = timeInMillis * 1000
        return timeFormatter.format(cv.time)
    }

    fun getDate(timeInMillis : Long): String {
        val cv = Calendar.getInstance()
        timeFormatter.timeZone = TimeZone.getDefault()
        cv.timeInMillis = timeInMillis * 1000
        return dateFormatter.format(cv.time)
    }
}