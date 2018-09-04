package com.example.ominext.cleanarch.domain.repository

import com.example.ominext.cleanarch.presentasion.model.WeatherData
import io.reactivex.Observable

interface MainRepos {
    fun getMessage(message: String): String

    fun getWeather(): Observable<WeatherData>
}