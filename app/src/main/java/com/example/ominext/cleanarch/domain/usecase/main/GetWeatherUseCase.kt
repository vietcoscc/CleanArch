package com.example.ominext.cleanarch.domain.usecase.main

import com.example.ominext.cleanarch.domain.repository.MainRepos
import com.example.ominext.cleanarch.presentasion.model.WeatherData
import io.reactivex.Observable
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor() {
    lateinit var mainRepos: MainRepos

    fun exe(): Observable<WeatherData> {
        return mainRepos.getWeather()
    }

}