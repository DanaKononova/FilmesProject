package com.example.filmesproject.ui.low_rating_films.presenter

import com.example.filmesproject.domain.GetLowRatingFilmUseCase
import com.example.filmesproject.ui.low_rating_films.LowRatingFilmsView

class LowRatingFilmsPresenterImpl(private var view: LowRatingFilmsView?) : LowRatingFilmsPresenter {
    private val useCase = GetLowRatingFilmUseCase()

    override fun getLowRatingFilms() {
        view?.showLowRatingFilms(useCase())
    }

    override fun onClear() {
        view = null
    }
}