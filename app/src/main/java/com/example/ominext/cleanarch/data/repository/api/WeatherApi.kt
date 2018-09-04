package com.example.ominext.cleanarch.data.repository.api

import com.example.ominext.cleanarch.presentasion.model.WeatherData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/data/2.5/weather")
    fun getWheather(@Query("lat") lat: Float, @Query("lon") lng: Float, @Query("appid") appid: String): Observable<WeatherData>
}