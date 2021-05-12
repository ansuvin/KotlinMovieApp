package com.example.kotlinmovieapp.ui.movie_list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmovieapp.databinding.ItemMovieListBinding
import com.example.kotlinmovieapp.model.MovieVO
import com.example.kotlinmovieapp.model.ResponseMovieList

class MovieAdapter () : RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    var list = listOf<MovieVO>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemMovieListBinding>(layoutInflater, viewType, parent,false)
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

    inner class ViewHolder(private val binding: ItemMovieListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieVO) {
            binding.movie =movie
            binding.executePendingBindings()
        }
    }
}