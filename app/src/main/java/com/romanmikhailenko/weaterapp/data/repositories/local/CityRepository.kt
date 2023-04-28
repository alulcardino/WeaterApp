package com.romanmikhailenko.weaterapp.data.repositories.local

import com.romanmikhailenko.weaterapp.data.db.CityDao
import com.romanmikhailenko.weaterapp.data.model.city.City
import com.romanmikhailenko.weaterapp.data.model.city.UpdateCity
import javax.inject.Inject

class CityRepository @Inject constructor(
    private val dao: CityDao
) {

    suspend fun searchCity(key: String) = dao.searchCity(key)
    suspend fun updateSavedCities(obj: UpdateCity) = dao.updateSavedCity(obj)
    fun getSavedCities(key: Int) = dao.getSavedCity(key)
    suspend fun deleteSavedCities(city: City) = dao.deleteSavedCity(city)
}