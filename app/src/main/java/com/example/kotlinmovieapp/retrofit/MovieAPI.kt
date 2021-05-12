package com.example.kotlinmovieapp.retrofit

import com.example.kotlinmovieapp.model.ResponseMovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface MovieAPI {
    @GET("movie/searchMovieList.json")
    fun getMovies(
        @Query("key") key: String
    ): Call<ResponseMovieList>
}