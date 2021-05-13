package com.example.kotlinmovieapp.ui.movie_detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmovieapp.R
import com.example.kotlinmovieapp.databinding.ItemStaffBinding
import com.example.kotlinmovieapp.model.PeopleName

class StaffAdapter: RecyclerView.Adapter<StaffAdapter.ViewHolder>() {
    var list = listOf<PeopleName>()
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffAdapter.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemStaffBinding>(
            LayoutInflater.from(parent.context), R.layout.item_staff, parent, false
        )
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StaffAdapter.ViewHolder, position: Int) {
        holder.bind(staff = list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: ItemStaffBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(staff: PeopleName) {
            binding.staff = staff
            binding.executePendingBindings()
        }
    }
}