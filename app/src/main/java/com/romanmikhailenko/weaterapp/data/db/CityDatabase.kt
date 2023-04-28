package com.romanmikhailenko.weaterapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.romanmikhailenko.weaterapp.data.model.city.City

@Database(
    entities = [City::class],
    version = 1
)
abstract class CityDatabase : RoomDatabase(){

    abstract fun getCityDao() : CityDao
}