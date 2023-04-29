package com.romanmikhailenko.weaterapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import com.romanmikhailenko.weaterapp.data.model.city.City
import com.romanmikhailenko.weaterapp.data.model.city.UpdateCity
import com.romanmikhailenko.weaterapp.data.model.current.Coord


@Dao
interface CityDao {
    @Query("SELECT * FROM city_bd WHERE name LIKE :key || '%'")
    suspend fun searchCity(key: String) : List<City>

    @Update(entity = City::class)
    suspend fun updateSavedCity(vararg obj: UpdateCity): Int

    @Query("SELECT * FROM city_bd WHERE isSaved = :key")
    fun getSavedCity(key: Int) : LiveData<List<City>>

    @Delete
    suspend fun deleteSavedCity(city: City)

    @Query("SELECT * FROM city_bd WHERE name =:key")
    fun getCoordByCity(key: String): LiveData<City>
}