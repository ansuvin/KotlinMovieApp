package com.example.kotlinmovieapp.model

import com.google.gson.annotations.SerializedName

data class ResponseMovieDetail(
    @SerializedName("movieInfoResult")
    val movieInfoResult: MovieResultInfo
)

data class MovieResultInfo(
    @SerializedName("movieInfo")
    val movieInfo: MovieInfo
)

data class MovieInfo(
    @SerializedName("movieNm")
    var title: String,
    @SerializedName("showTm")
    var showTime: String,
    @SerializedName("openDt")
    var openDate: String,
    @SerializedName("genres")
    var genres: List<MovieGenre>,
    @SerializedName("directors")
    var directors: List<PeopleName>,
    @SerializedName("actors")
    var actors: List<ActorName>,
    @SerializedName("audits")
    var audits: List<Audit>
)

data class MovieGenre(
    @SerializedName("genreNm")
    var title: String
)

data class Audit(
    @SerializedName("watchGradeNm")
    var content: String
)