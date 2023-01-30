package com.example.filmesproject.data

import com.example.filmesproject.Server
import com.example.filmesproject.data.mapper.FilmMapper
import com.example.filmesproject.domain.repository.FilmRepository
import com.example.filmesproject.domain.models.FilmData

class FilmDataRepositoryImpl : FilmRepository {
    val mapper = FilmMapper()
    override fun getFilms(): List<FilmData> = Server.getFilms().map { mapper(it) }
}