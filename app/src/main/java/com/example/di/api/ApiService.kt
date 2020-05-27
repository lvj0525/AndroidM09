package com.example.di.api

import com.example.di.model.Advice
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("advice")
    fun getAdvice(): Call<Advice>
}