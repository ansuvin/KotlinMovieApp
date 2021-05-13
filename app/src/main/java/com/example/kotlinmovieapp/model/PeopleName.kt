package com.example.kotlinmovieapp.model

import com.google.gson.annotations.SerializedName

data class PeopleName(
    @SerializedName("peopleNm")
    var name: String
)

data class ActorName(
    @SerializedName("peopleNm")
    var name: String,
    @SerializedName("cast")
    var cast: String
)