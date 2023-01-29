package com.example.filmesproject.domain.repository

import com.example.filmesproject.domain.models.FilmData

interface FilmRepository {
    fun getFilms(): List<FilmData>
}