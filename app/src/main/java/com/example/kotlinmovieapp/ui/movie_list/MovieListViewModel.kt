package com.example.kotlinmovieapp.ui.movie_list

import android.app.Application
import android.graphics.Movie
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmovieapp.model.MovieItems
import com.example.kotlinmovieapp.model.MovieVO
import com.example.kotlinmovieapp.model.ResponseMovieList
import com.example.kotlinmovieapp.repository.Repository
import com.example.kotlinmovieapp.retrofit.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MovieListViewModel(application: Application) : AndroidViewModel(application) {
    val TAG = "MovieListViewModel"
    val repository: Repository = Repository(application)
    val movie = repository.getMovieData()

    val list = MutableLiveData<List<MovieVO>>()

    fun rcvMovieList() {
        list.postValue(movie.value)
        Log.e(TAG, list.toString())
    }
}