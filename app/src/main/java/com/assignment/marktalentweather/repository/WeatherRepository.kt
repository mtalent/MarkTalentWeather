package com.assignment.marktalentweather.repository

import com.assignment.marktalentweather.api.ApiService
import com.assignment.marktalentweather.api.SafeApiRequest

class WeatherRepository(
    private val api: ApiService
) : SafeApiRequest() {
    suspend fun getWeather() = apiRequest { api.getWeather() }

}