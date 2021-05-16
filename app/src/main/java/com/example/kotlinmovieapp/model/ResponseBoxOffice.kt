package com.example.kotlinmovieapp.model

import com.google.gson.annotations.SerializedName

data class ResponseBoxOffice (
    @SerializedName("boxOfficeResult")
    var result: BoxOfficeResult
        )

data class BoxOfficeResult(
    @SerializedName("dailyBoxOfficeList")
    var list: List<MovieRankVO>
)

data class MovieRankVO(
    @SerializedName("rank")
    var rank: String,
    @SerializedName("rankInten")
    var inten: String,
    @SerializedName("rankOldAndNew")
    var oldAndNew: String,
    @SerializedName("movieCd")
    var movieCode: String,
    @SerializedName("movieNm")
    var title: String,
    @SerializedName("audiAcc")
    var audiAcc: String,
)