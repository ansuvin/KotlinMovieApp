package com.example.kotlinmovieapp.model

import com.google.gson.annotations.SerializedName

data class ResponseFilmmakerList(
    @SerializedName("peopleListResult")
    var result: FilmmkaerResult
)

data class FilmmkaerResult(
    @SerializedName("peopleList")
    var peopleList: List<PeopleName>
)
