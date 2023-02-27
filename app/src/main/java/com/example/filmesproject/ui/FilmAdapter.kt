package com.example.filmesproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmesproject.R
import com.example.filmesproject.databinding.RvFilmesListBinding
import com.example.filmesproject.domain.models.FilmData

class FilmAdapter(
    private val films: List<FilmData>,
    private val itemClick: (String, String) -> Unit
) : RecyclerView.Adapter<FilmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = RvFilmesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.onBind(films[position])
    }

    override fun getItemCount(): Int = films.size
}