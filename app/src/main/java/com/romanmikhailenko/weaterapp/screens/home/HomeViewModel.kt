package com.romanmikhailenko.weaterapp.screens.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.romanmikhailenko.weaterapp.data.api.ApiService
import com.romanmikhailenko.weaterapp.data.api.WeatherRepository
import com.romanmikhailenko.weaterapp.model.WeatherResponse
import com.romanmikhailenko.weaterapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(private val repository: WeatherRepository) : ViewModel()  {

    val weatherLiveData : MutableLiveData<Resource<WeatherResponse>> = MutableLiveData()

    init {
        getWeather(44.34, 10.99, "metric")
    }

    private fun getWeather(latitude: Double, longitude: Double, unit: String) =
        viewModelScope.launch {
            weatherLiveData.postValue(Resource.Loading())
            val response = repository.getWeather(latitude, longitude, unit)
            if (response.isSuccessful) {
                response.body().let { res ->
                    weatherLiveData.postValue(Resource.Success(res))
                }
            } else {
                weatherLiveData.postValue(Resource.Error(message = response.message()))
            }
        }
}