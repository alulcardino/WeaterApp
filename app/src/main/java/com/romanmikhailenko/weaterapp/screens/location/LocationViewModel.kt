package com.romanmikhailenko.weaterapp.screens.location

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.romanmikhailenko.weaterapp.data.model.city.City
import com.romanmikhailenko.weaterapp.data.model.city.UpdateCity
import com.romanmikhailenko.weaterapp.data.repositories.local.CityRepository
import com.romanmikhailenko.weaterapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class LocationViewModel @Inject constructor(
    val repository: CityRepository
) : ViewModel() {


    val cityByQuery = MutableLiveData<Resource<List<City>>>()

    fun updateSavedCities(obj: UpdateCity) = viewModelScope.launch {
        try {
            val info = repository.updateSavedCities(obj)
            Timber.tag("Success: Updating City DB: $info")
        } catch (e: Exception) {
            e.stackTrace
            Timber.tag("Error: Updating City DB: ${e.localizedMessage}")
        }
    }

    fun getCityByQuery(query: String) = viewModelScope.launch {
        safeCityByQueryFetch(query)
    }

    private suspend fun safeCityByQueryFetch(query: String) {
        cityByQuery.postValue(Resource.Loading())
        try {
            val response = repository.searchCity(key = query)
            cityByQuery.postValue(handleCitySearch(response))
        } catch (t: Throwable) {
            when (t) {
                is IOException -> cityByQuery.postValue(Resource.Error("Network Failure"))
                else -> {
                    cityByQuery.postValue(Resource.Error(t.localizedMessage))
                    Timber.tag("Error: Updating City DB: ${t.localizedMessage}")
                }
            }
        }
    }



    private fun handleCitySearch(response: List<City>): Resource<List<City>> =
        Resource.Success(response)

}