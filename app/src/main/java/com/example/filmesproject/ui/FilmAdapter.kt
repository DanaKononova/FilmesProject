package com.example.filmesproject.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmesproject.R
import com.example.filmesproject.domain.models.FilmData

class FilmAdapter(private val itemClick: (String, String) -> Unit) :
    RecyclerView.Adapter<FilmViewHolder>() {
    private val films: MutableList<FilmData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_filmes_list, parent, false)
        return FilmViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.onBind(films[position])
    }

    override fun getItemCount(): Int = films.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(films: List<FilmData>) {
        this.films.clear()
        this.films.addAll(films)
        notifyDataSetChanged()
    }
}