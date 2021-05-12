package com.example.kotlinmovieapp.ui.filmmaker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinmovieapp.R

class FilmmakerFragment : Fragment() {

    private lateinit var filmmakerViewModel: FilmmakerViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        filmmakerViewModel =
                ViewModelProvider(this).get(FilmmakerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_filmmaker_list, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        filmmakerViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root
    }
}