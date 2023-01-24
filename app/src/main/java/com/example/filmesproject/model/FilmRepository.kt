package com.example.filmesproject.model

import com.example.filmesproject.model.models.UnionType

interface FilmRepository {
    fun getFilms(): List<UnionType>
}