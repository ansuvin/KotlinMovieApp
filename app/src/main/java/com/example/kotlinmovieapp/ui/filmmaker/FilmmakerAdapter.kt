package com.example.kotlinmovieapp.ui.filmmaker

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmovieapp.R
import com.example.kotlinmovieapp.databinding.ItemFilmmakerListBinding
import com.example.kotlinmovieapp.databinding.ItemMovieListBinding
import com.example.kotlinmovieapp.model.PeopleName

class FilmmakerAdapter() : RecyclerView.Adapter<FilmmakerAdapter.ViewHolder>() {
    var list = listOf<PeopleName>()
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmmakerAdapter.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemFilmmakerListBinding>(
            LayoutInflater.from(parent.context), R.layout.item_filmmaker_list, parent, false
        )
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmmakerAdapter.ViewHolder, position: Int) {
        holder.bind(people = list[position])
    }

    override fun getItemCount(): Int {
        return list.size

    }

    inner class ViewHolder(private val binding: ItemFilmmakerListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(people: PeopleName) {
            val filmo = people.filmo
            people.filmo = filmo.replace("|", ", ")
            binding.people = people
            binding.executePendingBindings()
        }
    }
}