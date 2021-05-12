package com.example.kotlinmovieapp.ui.movie_list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmovieapp.R
import com.example.kotlinmovieapp.databinding.ItemMovieListBinding
import com.example.kotlinmovieapp.model.MovieVO

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    var list = listOf<MovieVO>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemMovieListBinding>(
            LayoutInflater.from(parent.context), R.layout.item_movie_list, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.bind(movie = list[position])

        holder.itemView.setOnClickListener {
            Log.e("TAG", "click: ${list[position].title}")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: ItemMovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieVO) {
            var vo = movie
            vo.openDate = "개봉년도: ${vo.openDate.substring(0,4)}년"
            binding.movie = vo
            binding.executePendingBindings()
        }
    }
}