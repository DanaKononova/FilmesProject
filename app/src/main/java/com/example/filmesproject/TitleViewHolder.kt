package com.example.filmesproject

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TitleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun onBind(item: UnionType.TitleData) {
        val filmType = itemView.findViewById<TextView>(R.id.title)
        filmType.text = item.filmType
    }
}