package com.example.kotlinmovieapp.ui.filmmaker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmovieapp.R
import com.example.kotlinmovieapp.databinding.FragmentFilmmakerListBinding
import com.example.kotlinmovieapp.model.PeopleName

class FilmmakerFragment : Fragment() {

    private lateinit var viewModel: FilmmakerViewModel
    private lateinit var binding: FragmentFilmmakerListBinding
    var data = MutableLiveData<List<PeopleName>>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false)
        viewModel =
            ViewModelProvider(this).get(FilmmakerViewModel::class.java)

        viewModel.list.observe(this.viewLifecycleOwner, { liveData ->
            data.value = liveData
            val mAdapter = FilmmakerAdapter()
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
        viewModel.rcvFilmmakerList()
    }
}