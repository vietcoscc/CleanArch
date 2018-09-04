package com.example.ominext.cleanarch.common.di.module

import com.example.ominext.cleanarch.common.di.utils.AppUtils
import com.example.ominext.cleanarch.data.repository.api.WeatherApi
import com.google.gson.GsonBuilder
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

class ApiModule {
    @Provides
    @Singleton
    fun providesWheatherApi(retrofit: Retrofit): WeatherApi {
        return retrofit.create<WeatherApi>(WeatherApi::class.java)
    }

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(1, TimeUnit.MINUTES)
        httpClient.readTimeout(30, TimeUnit.SECONDS)
        httpClient.writeTimeout(20, TimeUnit.SECONDS)
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ").serializeNulls().create()
        return Retrofit.Builder()
                .baseUrl(AppUtils.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build()
    }
}