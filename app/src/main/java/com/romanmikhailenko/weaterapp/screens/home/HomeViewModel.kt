package com.romanmikhailenko.weaterapp.screens.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.preference.PreferenceManager
import com.romanmikhailenko.weaterapp.data.model.city.Location
import com.romanmikhailenko.weaterapp.data.repositories.remote.WeatherRepository
import com.romanmikhailenko.weaterapp.data.model.current.WeatherResponse
import com.romanmikhailenko.weaterapp.data.model.forecast.ForecastResponse
import com.romanmikhailenko.weaterapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(private val repository: WeatherRepository, application: Application) : AndroidViewModel(application)  {

    private val context
    get() = getApplication<Application>()
    val weatherLiveData : MutableLiveData<Resource<WeatherResponse>> = MutableLiveData()
    val forecastLiveData : MutableLiveData<Resource<ForecastResponse>> = MutableLiveData()

    var coord = Location(73.37, 54.99 )



    private val sharedPreferences = context.let {
        PreferenceManager.getDefaultSharedPreferences(it)
    }
    fun getSharedPreferencesSettings() = sharedPreferences


    fun setWeather() {
        sharedPreferences.getString("units", "metric")?.let { getWeather(coord.latitude!!, coord.longitude!!, it) }
    }

//    fun setForecast() {
//        sharedPreferences.getString("units", "metric")?.let { getForecast(44.34, 10.99, it) }
//    }

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



//    private fun getForecast(latitude: Double, longitude: Double, unit: String) =
//        viewModelScope.launch {
//            forecastLiveData.postValue(Resource.Loading())
//            val response = repository.getForecast(latitude, longitude, unit)
//            if (response.isSuccessful) {
//                response.body().let { res ->
//                    forecastLiveData.postValue(Resource.Success(res))
//                }
//            } else {
//                forecastLiveData.postValue(Resource.Error(message = response.message()))
//            }
//        }
}