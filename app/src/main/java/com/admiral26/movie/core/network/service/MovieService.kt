package com.admiral26.movie.core.network.service

import com.admiral26.movie.core.model.footerRes.FooterRespons
import com.admiral26.movie.core.model.headerRes.HeaderRespons
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/3/movie/now_playing")
    suspend fun getHeader(@Query("api_key") apiKey: String):Response<HeaderRespons?>

    @GET("/3/movie/popular")
    suspend fun getFooter(@Query("api_key")apiKey: String):Response<FooterRespons?>
}