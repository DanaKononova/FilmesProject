package com.example.filmesproject.domain.models

data class FilmData(
    val poster: String,
    val name: String,
    val hasOskar: Boolean,
    val rating: Double,
    val description: String
)