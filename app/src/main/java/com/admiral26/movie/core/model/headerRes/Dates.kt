package com.admiral26.movie.core.model.headerRes


import com.google.gson.annotations.SerializedName

data class Dates(
    @SerializedName("maximum")
    val maximum: String, // 2024-02-07
    @SerializedName("minimum")
    val minimum: String // 2023-12-27
)