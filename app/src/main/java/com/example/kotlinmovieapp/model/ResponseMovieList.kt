package com.example.kotlinmovieapp.model

import com.google.gson.annotations.SerializedName

data class ResponseMovieList(
    @SerializedName("movieListResult")
    var result: MovieListResult
)

data class MovieListResult(
    @SerializedName("movieList")
    var list: List<MovieVO>
)

data class MovieVO(
    @SerializedName("movieCd")
    var movieCode: String,
    @SerializedName("movieNm")
    var title: String,

    @SerializedName("openDt")
    var openDate: String,

    @SerializedName("directors")
    var directors: List<PeopleName>
)

data class PeopleName(
    @SerializedName("peopleNm")
    var name: String
)