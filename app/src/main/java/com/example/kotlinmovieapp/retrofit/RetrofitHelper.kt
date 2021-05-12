package com.example.kotlinmovieapp.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    const val BASE_URL = "http://kobis.or.kr/kobisopenapi/webservice/rest/"
    private var instance: Retrofit? = null
    private val gson = GsonBuilder()
        .setLenient()
        .create()

    fun getMovieApi(): MovieAPI {
        return getInstance().create(MovieAPI::class.java)
    }

    fun getInstance() : Retrofit {
        if (instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

        return instance!!
    }
}