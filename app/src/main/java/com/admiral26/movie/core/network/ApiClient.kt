package com.admiral26.movie.core.network

import com.admiral26.movie.core.app.App
import com.admiral26.movie.core.network.service.MovieService
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(" https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

   /* private fun getOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .callTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(provideChunker())
            .build()
    }

    private fun provideChunker(): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(App.instance)
            .maxContentLength(250_000)
            .alwaysReadResponseBody(true)
            .build()
    }
*/
    fun createService(): MovieService = getRetrofit().create(MovieService::class.java)
}