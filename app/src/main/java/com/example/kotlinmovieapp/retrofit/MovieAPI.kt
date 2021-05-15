package com.example.kotlinmovieapp.retrofit

import com.example.kotlinmovieapp.model.ResponseBoxOffice
import com.example.kotlinmovieapp.model.ResponseFilmmakerList
import com.example.kotlinmovieapp.model.ResponseMovieDetail
import com.example.kotlinmovieapp.model.ResponseMovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface MovieAPI {
    @GET("movie/searchMovieList.json")
    fun getMovies(
        @Query("key") key: String,
        @Query("openStartDt") openDate: String
    ): Call<ResponseMovieList>

    @GET("movie/searchMovieList.json")
    fun getSearchMovies(
        @Query("key") key: String,
        @Query("movieNm") title: String
    ): Call<ResponseMovieList>

    @GET("movie/searchMovieInfo.json")
    fun getMovieDetail(
        @Query("key") key: String,
        @Query("movieCd") movieCode: String
    ): Call<ResponseMovieDetail>

    @GET("people/searchPeopleList.json?")
    fun getFilmmakers(
        @Query("key") key: String
    ): Call<ResponseFilmmakerList>

    @GET("people/searchPeopleList.json?")
    fun getSearchFilmmakersFilmo(
        @Query("key") key: String,
        @Query("filmoNames") filmo: String
    ): Call<ResponseFilmmakerList>

    @GET("people/searchPeopleList.json?")
    fun getSearchFilmmakersName(
        @Query("key") key: String,
        @Query("filmoNames") name: String
    ): Call<ResponseFilmmakerList>

    @GET("boxoffice/searchDailyBoxOfficeList.json?")
    fun getBoxOfficeList(
        @Query("key") key: String,
        @Query("targetDt") date: String
    ): Call<ResponseBoxOffice>
}