package com.example.filmesproject.data

import com.example.filmesproject.data.mapper.FilmMapper
import com.example.filmesproject.domain.repository.FilmRepository
import com.example.filmesproject.domain.FilmRepositoryImpl
import com.example.filmesproject.domain.models.FilmData

class FilmDataResponseImpl : FilmRepository {
    val mapper = FilmMapper()
    override fun getFilms(): List<FilmData> = FilmRepositoryImpl().getFilms().map { mapper(it) }
}