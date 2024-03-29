package com.example.kotlinmovieapp.ui.movie_list

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlinmovieapp.model.MovieVO
import com.example.kotlinmovieapp.model.ResponseMovieList
import com.example.kotlinmovieapp.retrofit.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListViewModel(application: Application) : AndroidViewModel(application) {
    val TAG = "MovieListViewModel"

    val list = MutableLiveData<List<MovieVO>>()
    var query = MutableLiveData<String>()

    fun rcvMovieList() {
        val call = RetrofitHelper.getMovieApi().getMovies("f5eef3421c602c6cb7ea224104795888", "2020")
            call.enqueue(object : Callback<ResponseMovieList> {
                override fun onResponse(
                    call: Call<ResponseMovieList>,
                    response: Response<ResponseMovieList>
                ) {
                    if (response.isSuccessful){
                        list.value = response.body()!!.result.list
                        Log.e(TAG, "ㅎㅎ: ${response.body()!!.result.list}")
                    }
                }

                override fun onFailure(call: Call<ResponseMovieList>, t: Throwable) {
                    Log.e(TAG, "error: ${t.message}")
                }
            })
    }

    fun searchQuery() {
        val queryStr = query.value.toString()
        Log.i(TAG, "click ${queryStr}")
        val callback = RetrofitHelper.getMovieApi().getSearchMovies("f5eef3421c602c6cb7ea224104795888", queryStr)
        callback.enqueue(object : Callback<ResponseMovieList> {
            override fun onResponse(
                call: Call<ResponseMovieList>,
                response: Response<ResponseMovieList>
            ) {
                if (response.isSuccessful) {
                    list.value = response.body()!!.result.list
                } else {
                    Log.e(TAG, "res-err: ${response.message()}")
                }

            }

            override fun onFailure(call: Call<ResponseMovieList>, t: Throwable) {
                Log.e(TAG, "error: ${t.message}")
            }

        })
    }
}