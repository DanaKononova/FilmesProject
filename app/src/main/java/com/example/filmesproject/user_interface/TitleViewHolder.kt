package com.example.filmesproject.user_interface

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.filmesproject.R
import com.example.filmesproject.model.models.UnionType

class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun onBind(item: UnionType.TitleData) {
        val filmType = itemView.findViewById<TextView>(R.id.title)
        filmType.text = item.filmType
    }
}