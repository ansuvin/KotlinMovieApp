package com.example.kotlinmovieapp.ui.movie_rank

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmovieapp.model.MovieRankVO
import com.example.kotlinmovieapp.model.MovieVO
import com.example.kotlinmovieapp.model.ResponseBoxOffice
import com.example.kotlinmovieapp.model.ResponseMovieList
import com.example.kotlinmovieapp.retrofit.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class MovieRankViewModel : ViewModel() {
    val TAG = "MovieRankViewModel"

    val list = MutableLiveData<List<MovieRankVO>>()

    fun rcvMovieRankList() {
        val format = SimpleDateFormat("yyyyMMdd")
        val curDate = format.format(Date(Date().time+(1000*60*60*24*-1)))
        Log.e(TAG, curDate)
        val call = RetrofitHelper.getMovieApi().getBoxOfficeList("f5eef3421c602c6cb7ea224104795888", curDate)
        call.enqueue(object : Callback<ResponseBoxOffice> {
            override fun onResponse(
                call: Call<ResponseBoxOffice>,
                response: Response<ResponseBoxOffice>
            ) {
                if (response.isSuccessful){
                    list.value = response.body()!!.result.list
                    Log.e(TAG, "ㅎㅎ: ${response.body()!!.result.list}")
                }
            }

            override fun onFailure(call: Call<ResponseBoxOffice>, t: Throwable) {
                Log.e(TAG, "error: ${t.message}")
            }
        })
    }

}