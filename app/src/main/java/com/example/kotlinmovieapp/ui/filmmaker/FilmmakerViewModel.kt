package com.example.kotlinmovieapp.ui.filmmaker

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmovieapp.model.PeopleName
import com.example.kotlinmovieapp.model.ResponseFilmmakerList
import com.example.kotlinmovieapp.model.ResponseMovieList
import com.example.kotlinmovieapp.retrofit.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmmakerViewModel : ViewModel() {

    val TAG = "FilmmakerViewModel"

    val list = MutableLiveData<MutableList<PeopleName>>()
    var query = MutableLiveData<String>()

    fun rcvFilmmakerList() {
        val call = RetrofitHelper.getMovieApi().getFilmmakers("f5eef3421c602c6cb7ea224104795888")
        call.enqueue(object : Callback<ResponseFilmmakerList> {
            override fun onResponse(
                call: Call<ResponseFilmmakerList>,
                response: Response<ResponseFilmmakerList>
            ) {
                if (response.isSuccessful){
                    list.value = response.body()!!.result.peopleList as ArrayList
                    Log.e(TAG, "ㅎㅎ: ${response.body()!!.result.peopleList}")
                } else {
                    Log.e(TAG, "error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseFilmmakerList>, t: Throwable) {
                Log.e(TAG, "error: ${t.message}")
            }
        })
    }

    fun searchQuery() {
        val queryStr = query.value.toString()
        Log.i(TAG, "click ${queryStr}")
        val callback = RetrofitHelper.getMovieApi().getSearchFilmmakersName("f5eef3421c602c6cb7ea224104795888", queryStr)
        callback.enqueue(object : Callback<ResponseFilmmakerList> {
            override fun onResponse(
                call: Call<ResponseFilmmakerList>,
                response: Response<ResponseFilmmakerList>
            ) {
                if (response.isSuccessful) {
                    list.value = response.body()!!.result.peopleList as ArrayList
                } else {
                    Log.e(TAG, "res-err: ${response.message()}")
                }

            }

            override fun onFailure(call: Call<ResponseFilmmakerList>, t: Throwable) {
                Log.e(TAG, "error: ${t.message}")
            }

        })
    }
}