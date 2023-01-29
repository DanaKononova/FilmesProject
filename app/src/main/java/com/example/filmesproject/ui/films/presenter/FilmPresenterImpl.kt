package com.example.filmesproject.ui.films.presenter

import com.example.filmesproject.domain.FilmRepositoryImpl
import com.example.filmesproject.ui.films.FilmView

class FilmPresenterImpl(private var view: FilmView?) : FilmPresenter {
    private val repository: FilmRepositoryImpl = FilmRepositoryImpl()

    override fun getFilms() {
        val films = repository.getFilms()
        view?.showFilms(films)
    }

    override fun onClear() {
        view = null
    }
}