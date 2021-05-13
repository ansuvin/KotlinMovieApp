package com.example.kotlinmovieapp.ui.movie_detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmovieapp.R
import com.example.kotlinmovieapp.databinding.ItemActorBinding
import com.example.kotlinmovieapp.model.ActorName

class ActorAdapter: RecyclerView.Adapter<ActorAdapter.ViewHolder>() {
    var list = listOf<ActorName>()
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorAdapter.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemActorBinding>(
            LayoutInflater.from(parent.context), R.layout.item_actor, parent, false
        )
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActorAdapter.ViewHolder, position: Int) {
        holder.bind(actor = list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: ItemActorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(actor: ActorName) {
            binding.actor = actor
            binding.executePendingBindings()
        }
    }
}