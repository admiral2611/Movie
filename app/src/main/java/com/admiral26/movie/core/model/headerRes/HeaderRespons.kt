package com.admiral26.movie.core.model.headerRes


import com.admiral26.movie.core.model.BaseModel
import com.google.gson.annotations.SerializedName

data class HeaderRespons(
    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val results: List<ResultArticles>,
    @SerializedName("total_pages")
    val totalPages: Int, // 168
    @SerializedName("total_results")
    val totalResults: Int // 3342
) : BaseModel() {
    override fun getType(): Int {
        return TOP_HEAD_LINE
    }
}