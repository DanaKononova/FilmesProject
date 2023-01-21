package com.example.filmesproject

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FilmAdapter(private val itemClick: (String, String) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val TITLE_TYPE = 1
        private const val BODY_TYPE = 2
    }

    private val films: MutableList<UnionType> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            BODY_TYPE -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.rv_filmes_list, parent, false)
                FilmViewHolder(view, itemClick)
            }
            TITLE_TYPE -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.rv_title, parent, false)
                TitleViewHolder(view)
            }
            else -> throw Exception()
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FilmViewHolder -> holder.onBind(films[position] as UnionType.FilmData)
            is TitleViewHolder -> holder.onBind(films[position] as UnionType.TitleData)
        }
    }

    override fun getItemCount(): Int = films.size

    override fun getItemViewType(position: Int): Int = when (films[position]) {
        is UnionType.TitleData -> TITLE_TYPE
        is UnionType.FilmData -> BODY_TYPE
        else -> throw Exception()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(films: List<UnionType>) {
        this.films.clear()
        this.films.addAll(films)
        notifyDataSetChanged()
    }
}