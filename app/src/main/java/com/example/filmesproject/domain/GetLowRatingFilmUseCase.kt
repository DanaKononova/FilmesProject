package com.example.filmesproject.domain

import com.example.filmesproject.data.FilmDataResponseImpl
import com.example.filmesproject.domain.models.FilmData
import com.example.filmesproject.domain.repository.FilmRepository

class GetLowRatingFilmUseCase {
    companion object {
        private const val LOW_RATING = 8.0
    }

    private val repository: FilmRepository = FilmDataResponseImpl()

    operator fun invoke(): List<FilmData> = repository.getFilms()
        .filter { it.rating <= LOW_RATING }
}