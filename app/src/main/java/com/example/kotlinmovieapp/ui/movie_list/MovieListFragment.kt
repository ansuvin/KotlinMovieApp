package com.example.kotlinmovieapp.ui.movie_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmovieapp.R
import com.example.kotlinmovieapp.databinding.FragmentMovieListBinding
import com.example.kotlinmovieapp.model.MovieVO
import com.example.kotlinmovieapp.model.ResponseMovieList

class MovieListFragment : Fragment() {

    private lateinit var movieViewModel: MovieListViewModel
    private lateinit var binding : FragmentMovieListBinding
    var data = MutableLiveData<List<MovieVO>>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false)
        movieViewModel =
            ViewModelProvider(this).get(MovieListViewModel::class.java)

        movieViewModel.list.observe(this.viewLifecycleOwner, { liveData ->
            data.value = liveData
            val mAdapter = MovieAdapter()
            binding.fragmentRecyclerview.adapter = mAdapter
            binding.fragmentRecyclerview.layoutManager = LinearLayoutManager(this.context)
            binding.fragmentRecyclerview.setHasFixedSize(true)
            mAdapter.list = data.value!!
        })

        binding.movieListViewModel = movieViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        movieViewModel.rcvMovieList()
    }
}