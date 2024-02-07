package com.admiral26.movie.core.model.footerRes


import com.google.gson.annotations.SerializedName

data class ResultFootArticle(
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("backdrop_path")
    val backdropPath: String, // /4MCKNAc6AbWjEsM2h9Xc29owo4z.jpg
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    val id: Int, // 866398
    @SerializedName("original_language")
    val originalLanguage: String, // en
    @SerializedName("original_title")
    val originalTitle: String, // The Beekeeper
    @SerializedName("overview")
    val overview: String, // One man’s campaign for vengeance takes on national stakes after he is revealed to be a former operative of a powerful and clandestine organization known as Beekeepers.
    @SerializedName("popularity")
    val popularity: Double, // 4874.325
    @SerializedName("poster_path")
    val posterPath: String, // /A7EByudX0eOzlkQ2FIbogzyazm2.jpg
    @SerializedName("release_date")
    val releaseDate: String, // 2024-01-10
    @SerializedName("title")
    val title: String, // The Beekeeper
    @SerializedName("video")
    val video: Boolean, // false
    @SerializedName("vote_average")
    val voteAverage: Double, // 7.442
    @SerializedName("vote_count")
    val voteCount: Int // 677
)