package com.example.kotlinmovieapp.ui.movie_rank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmovieapp.R
import com.example.kotlinmovieapp.databinding.FragmentMovieListBinding
import com.example.kotlinmovieapp.databinding.FragmentMovieRankBinding
import com.example.kotlinmovieapp.model.MovieRankVO
import com.example.kotlinmovieapp.model.MovieVO
import com.example.kotlinmovieapp.ui.movie_list.MovieAdapter
import com.example.kotlinmovieapp.ui.movie_list.MovieListViewModel

class MovieRankFragment : Fragment() {

    private lateinit var viewModel: MovieRankViewModel
    private lateinit var binding: FragmentMovieRankBinding
    var data = MutableLiveData<List<MovieRankVO>>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movie_rank, container, false)
        viewModel =
            ViewModelProvider(this).get(MovieRankViewModel::class.java)

        viewModel.list.observe(this.viewLifecycleOwner, { liveData ->
            data.value = liveData
            val mAdapter = MovieRankAdapter()
            binding.fragmentRecyclerview.adapter = mAdapter
            binding.fragmentRecyclerview.layoutManager = LinearLayoutManager(this.context)
            binding.fragmentRecyclerview.setHasFixedSize(true)
            mAdapter.list = data.value!!
        })

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.rcvMovieRankList()
    }
}