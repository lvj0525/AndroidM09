package com.example.di.di

import com.example.di.MyRepository
import com.example.di.MyViewModel
import com.example.di.api.ApiService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel { MyViewModel(get()) }
}

val repositoryModule = module {
    single { MyRepository(get()) }
}

val apiModule = module {
    fun provideApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    single { provideApi(get()) }
}

val netModule = module {
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.adviceslip.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { provideRetrofit() }
}