package com.example.filmesproject

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FilmViewHolder(itemView: View, private val itemClick: (String, String) -> Unit): RecyclerView.ViewHolder(itemView) {
    fun onBind(item: UnionType.FilmData) {
        val poster = itemView.findViewById<ImageView>(R.id.ivPoster)
        val name = itemView.findViewById<TextView>(R.id.tvName)
        val hasOscar = itemView.findViewById<ImageView>(R.id.ivHasOscar)
        val rating = itemView.findViewById<TextView>(R.id.tvRating)

        Glide
            .with(itemView)
            .load(item.poster)
            .into(poster)
        name.text = item.name
        hasOscar.isVisible = item.hasOskar
        rating.text = "rating " + item.rating

        itemView.setOnClickListener {
            itemClick.invoke(item.name, item.description)
        }
    }
}