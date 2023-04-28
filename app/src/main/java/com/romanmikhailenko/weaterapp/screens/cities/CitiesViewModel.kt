package com.romanmikhailenko.weaterapp.screens.cities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.romanmikhailenko.weaterapp.data.model.city.City
import com.romanmikhailenko.weaterapp.data.repositories.local.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val repository: CityRepository
) : ViewModel() {

    fun getSavedCities(key: Int) = repository.getSavedCities(key)


    fun deleteSavedCities(city: City) = viewModelScope.launch {
        try {
            repository.deleteSavedCities(city)
        } catch (e: Exception) {
            e.stackTrace
            Timber.tag("Error: Updating City DB: ${e.localizedMessage}")
        }
    }
}