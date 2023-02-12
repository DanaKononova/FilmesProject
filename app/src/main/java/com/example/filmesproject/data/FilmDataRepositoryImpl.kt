package com.example.filmesproject.data

import com.example.filmesproject.data.mapper.FilmMapper
import com.example.filmesproject.domain.repository.FilmRepository
import com.example.filmesproject.domain.models.FilmData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilmDataRepositoryImpl @Inject constructor(
    private val mapper: FilmMapper,
    private val server: Server
) : FilmRepository {
    override fun getFilms(): List<FilmData> = server.getFilms().map { mapper(it) }
}