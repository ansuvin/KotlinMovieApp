package com.example.kotlinmovieapp.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinmovieapp.model.MovieVO
import com.example.kotlinmovieapp.model.ResponseMovieList
import com.example.kotlinmovieapp.retrofit.MovieAPI
import com.example.kotlinmovieapp.retrofit.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Repository(application: Application) {
    private val retrofit: Retrofit = RetrofitHelper.getInstance()
    private val api = retrofit.create(MovieAPI::class.java)

    fun getMovieData(): LiveData<List<MovieVO>> {
        val data = MutableLiveData<List<MovieVO>>()

        api.getMovies("f5eef3421c602c6cb7ea224104795888", "2020").enqueue(object : Callback<ResponseMovieList> {
            override fun onResponse(
                call: Call<ResponseMovieList>,
                response: Response<ResponseMovieList>
            ) {
                data.value = response.body()!!.result.list
                Log.e("Repository", data.value.toString())
            }

            override fun onFailure(call: Call<ResponseMovieList>, t: Throwable) {
                t.stackTrace
            }
        })

        return data
    }
}