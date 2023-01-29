package com.example.filmesproject.model.models

sealed class UnionType {
    data class FilmData(
        val poster: String,
        val name: String,
        val hasOskar: Boolean,
        val rating: Double,
        val description: String
    ) : UnionType()

    data class TitleData(val filmType: String) : UnionType()
}
