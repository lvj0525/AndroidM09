package com.example.di

import com.example.di.api.ApiService

class MyRepository(private val apiService: ApiService) {

    fun getAdvice() = apiService.getAdvice()
}