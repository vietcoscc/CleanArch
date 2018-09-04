package com.example.ominext.cleanarch.data.repository

import com.example.ominext.cleanarch.data.repository.api.WeatherApi
import com.example.ominext.cleanarch.domain.repository.MainRepos
import com.example.ominext.cleanarch.domain.usecase.main.GetMessageUseCase
import com.example.ominext.cleanarch.presentasion.model.Weather
import com.example.ominext.cleanarch.presentasion.model.WeatherData
import io.reactivex.Observable
import javax.inject.Inject

class MainReposImp @Inject constructor() : MainRepos {

    @Inject
    lateinit var weatherApi: WeatherApi

    override fun getMessage(message: String): String {
        return message
    }

    override fun getWeather(): Observable<WeatherData> {
        return weatherApi.getWheather(1f, 1f, "").map { weather -> return@map weather }
    }

}