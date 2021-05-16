package com.example.kotlinmovieapp.model

data class MovieDTO(
    var directors: List<PeopleName>,
    var openDate: String,
    var title: String
)
