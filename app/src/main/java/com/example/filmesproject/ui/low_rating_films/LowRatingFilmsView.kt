package com.example.filmesproject.ui.low_rating_films

import com.example.filmesproject.domain.models.FilmData

interface LowRatingFilmsView {
    fun showLowRatingFilms(films: List<FilmData>)
}