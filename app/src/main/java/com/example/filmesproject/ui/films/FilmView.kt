package com.example.filmesproject.ui.films

import com.example.filmesproject.data.models.FilmDataResponse

interface FilmView {
    fun showFilms(films: List<FilmDataResponse>)
}