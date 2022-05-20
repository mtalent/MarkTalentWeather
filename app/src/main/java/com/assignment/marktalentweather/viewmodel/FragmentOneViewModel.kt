package com.assignment.marktalentweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assignment.marktalentweather.coroutines.Coroutines
import com.assignment.marktalentweather.model.ResponseWeather
import com.assignment.marktalentweather.model.Weather
import com.assignment.marktalentweather.repository.WeatherRepository

class FragmentOneViewModel(
   private val repository : WeatherRepository
   ): ViewModel() {

   private lateinit var job: Job

   private val _weather = MutableLiveData<List<ResponseWeather>>()
   val weather: LiveData<List<ResponseWeather>>
      get() = _weather

   fun getWeather() {
      job = Coroutines.ioThenMain(
         {repository.getWeather()},
         { _weather.value = it}
      )
   }

   override fun OnCleared() {
      super.onCleared()
      if(::job.isInitialized) job.cancel()
   }

}