package com.admiral26.movie.core.model.footerRes


import com.admiral26.movie.core.model.BaseModel
import com.google.gson.annotations.SerializedName

data class FooterRespons(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val resultFootArticles: List<ResultFootArticle>,
    @SerializedName("total_pages")
    val totalPages: Int, // 42646
    @SerializedName("total_results")
    val totalResults: Int // 852918
): BaseModel() {
    override fun getType(): Int {
        return FOOT_LINE
    }
}