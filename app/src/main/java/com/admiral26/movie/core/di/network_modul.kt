package com.admiral26.movie.core.di

import com.admiral26.movie.core.network.service.MovieService
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(" https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .callTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(get<ChuckerInterceptor>())
            .build()
    }

    single<ChuckerInterceptor> {
        ChuckerInterceptor.Builder(get())
            .maxContentLength(250_000)
            .alwaysReadResponseBody(true)
            .build()
    }

    single<MovieService> {
        get<Retrofit>().create(MovieService::class.java)
    }

}