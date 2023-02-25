package com.example.filmesproject.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmesproject.R
import com.example.filmesproject.databinding.FragmentMainBinding
import com.example.filmesproject.databinding.RvFilmesListBinding
import com.example.filmesproject.domain.models.FilmData

class FilmViewHolder(private val binding: RvFilmesListBinding, private val itemClick: (String, String) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: FilmData) {
        binding.tvName.text = item.name
        binding.ivHasOscar.isVisible = item.hasOskar
        binding.tvRating.text = "rating " + item.rating

        Glide
            .with(itemView)
            .load(item.poster)
            .into(binding.ivPoster)

        itemView.setOnClickListener {
            itemClick.invoke(item.name, item.description)
        }
    }
}