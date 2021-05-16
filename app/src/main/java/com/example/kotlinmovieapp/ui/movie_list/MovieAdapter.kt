package com.example.kotlinmovieapp.ui.movie_list

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmovieapp.R
import com.example.kotlinmovieapp.databinding.ItemMovieListBinding
import com.example.kotlinmovieapp.model.MovieDTO
import com.example.kotlinmovieapp.model.MovieVO
import com.example.kotlinmovieapp.ui.movie_detail.MovieDetailActivity

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    var list = listOf<MovieVO>()
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemMovieListBinding>(
            LayoutInflater.from(parent.context), R.layout.item_movie_list, parent, false
        )
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.bind(movie = list[position])

        holder.itemView.setOnClickListener {
            Log.e("TAG", "click: ${list[position].movieCode}")
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra("movieCode", list[position].movieCode)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: ItemMovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieVO) {
            var vo = movie
            var dto = MovieDTO(vo.directors, "", vo.title)
            if (vo.openDate != "") {
                dto.openDate = "개봉년도: ${vo.openDate.substring(0,4)}년"
            } else {
                dto.openDate = "개봉년도: 알 수 없음"
            }
            binding.movie = dto
            binding.executePendingBindings()
        }
    }
}