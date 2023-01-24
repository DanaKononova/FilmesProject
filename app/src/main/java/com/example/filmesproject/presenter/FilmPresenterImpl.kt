package com.example.filmesproject.presenter

import com.example.filmesproject.model.FilmRepository
import com.example.filmesproject.model.FilmRepositoryImpl
import com.example.filmesproject.user_interface.FilmView

class FilmPresenterImpl(private var view: FilmView?) : FilmPresenter {
    private val repository: FilmRepository = FilmRepositoryImpl()

    override fun getFilms() {
        val films = repository.getFilms()
        view?.showFilms(films)
    }

    override fun onClear() {
        view = null
    }
}