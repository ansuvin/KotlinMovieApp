package com.example.kotlinmovieapp.ui.movie_detail

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlinmovieapp.model.MovieInfo
import com.example.kotlinmovieapp.model.ResponseMovieDetail
import com.example.kotlinmovieapp.retrofit.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailViewModel(application: Application) : AndroidViewModel(application) {
    val TAG = "MovieDetailViewModel"

    val movie = MutableLiveData<MovieInfo>()
    val infoStr = MutableLiveData<String>()
    var movieCode = MutableLiveData<String>()

    fun initView() {
        val call = RetrofitHelper.getMovieApi().getMovieDetail("f5eef3421c602c6cb7ea224104795888", movieCode = movieCode.value!!)
        call.enqueue(object : Callback<ResponseMovieDetail> {
            override fun onResponse(
                call: Call<ResponseMovieDetail>,
                response: Response<ResponseMovieDetail>
            ) {
                if (response.isSuccessful) {
                    movie.value = response.body()!!.movieInfoResult.movieInfo
                    var genreStr = ""
                    var genres = mutableListOf<String>()
                    for (i in movie.value!!.genres) {
                        genres.add(i.title)
                    }
                    genreStr = genres.joinToString(separator = ", ")
                    infoStr.value = "${genreStr} | ${movie.value!!.showTime}분 | ${movie.value!!.openDate} 개봉\n${movie.value!!.audits[0].content}"
                }
            }

            override fun onFailure(call: Call<ResponseMovieDetail>, t: Throwable) {
                Log.e(TAG, "error: ${t.message}")
            }

        })
    }
}