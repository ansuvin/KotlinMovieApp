package com.example.kotlinmovieapp.ui.movie_rank

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmovieapp.R
import com.example.kotlinmovieapp.databinding.ItemMovieRankBinding
import com.example.kotlinmovieapp.model.MovieDTO
import com.example.kotlinmovieapp.model.MovieRankVO

class MovieRankAdapter : RecyclerView.Adapter<MovieRankAdapter.ViewHolder>() {
    var list = listOf<MovieRankVO>()
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRankAdapter.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemMovieRankBinding>(
            LayoutInflater.from(parent.context), R.layout.item_movie_rank, parent, false
        )
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movie = list[position])
    }


    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: ItemMovieRankBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieRankVO) {
            var vo = movie
            var dto = MovieDTO("", "", false, "","", 0, "")
            dto.inten = vo.inten
            dto.intenInt = vo.inten.toInt()
            when(dto.intenInt){
                0 -> dto.intenStr = "-"
                in 1..100 -> dto.intenStr = "▲"
                else -> dto.intenStr = "▼"
            }
            dto.title = vo.title
            dto.audiAcc = "누적 관객수: ${vo.audiAcc}명"
            dto.rank = "${vo.rank}위"
            dto.boolOld = vo.oldAndNew != "NEW"
            binding.movie = dto
            binding.executePendingBindings()
        }
    }


}