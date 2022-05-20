package com.assignment.marktalentweather.api

import com.assignment.marktalentweather.model.ResponseWeather
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("forecast")
   suspend fun getWeather() : Response<List<ResponseWeather>>

    companion object {
        operator fun invoke() : ApiService {

           return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.openweathermap.org/data/2.5")
                .build()
                .create(ApiService::class.java)

        }
    }

}