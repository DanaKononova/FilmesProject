package com.example.filmesproject.user_interface

import com.example.filmesproject.model.models.UnionType

interface FilmView {
    fun showFilms(films: List<UnionType>)
}