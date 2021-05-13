package com.example.kotlinmovieapp.ui.movie_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmovieapp.R
import com.example.kotlinmovieapp.databinding.ActivityMovieDetailBinding
import com.example.kotlinmovieapp.model.MovieInfo
import com.example.kotlinmovieapp.ui.movie_list.MovieAdapter

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: MovieDetailViewModel
    private lateinit var binding: ActivityMovieDetailBinding
    var data = MutableLiveData<MovieInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        viewModel =
            ViewModelProvider(this).get(MovieDetailViewModel::class.java)

        if (intent.hasExtra("movieCode")) {
            viewModel.movieCode.value = intent.getStringExtra("movieCode")!!
            viewModel.initView()
        }

        viewModel.movie.observe(this, { liveData ->
            data.value = liveData
            val mAdapter = StaffAdapter()
            binding.staffRcv.adapter = mAdapter
            val mLayoutManager = LinearLayoutManager(this)
            mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
            binding.staffRcv.layoutManager = mLayoutManager
            binding.staffRcv.setHasFixedSize(true)
            mAdapter.list = data.value!!.directors

            val nAdapter = ActorAdapter()
            binding.actorRcv.adapter = nAdapter
            val nLayoutManager = LinearLayoutManager(this)
            nLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
            binding.actorRcv.layoutManager = nLayoutManager
            binding.actorRcv.setHasFixedSize(true)
            nAdapter.list = data.value!!.actors

            Log.e("TAGG", "actors: ${data.value!!.actors}")
        })

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }
}