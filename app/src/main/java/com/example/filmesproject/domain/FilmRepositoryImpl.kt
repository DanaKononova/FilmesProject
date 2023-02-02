package com.example.filmesproject.domain

import com.example.filmesproject.data.models.FilmDataResponse

class FilmRepositoryImpl {
    fun getFilms(): List<FilmDataResponse> = listOf(
        FilmDataResponse(
            "https://avatars.mds.yandex.net/get-kinopoisk-image/6201401/a2d5bcae-a1a9-442f-8195-f5373a5ba77f/600x900",
            "Властилин Колец: братство кольца",
            true,
            8.6,
            "первый фильм"
        ),
        FilmDataResponse(
            "https://avatars.mds.yandex.net/get-kinopoisk-image/6201401/772093e4-7f68-49aa-a805-d654693aee26/600x900",
            "Властилин Колец: две крепости",
            true,
            8.6,
            "second film"
        ),
        FilmDataResponse(
            "https://avatars.mds.yandex.net/get-kinopoisk-image/4303601/e410c71f-baa1-4fe5-bb29-aedb4662f49b/600x900",
            "Властилин Колец: возвращение короля",
            true,
            8.7,
            "third film"
        ),
        FilmDataResponse(
            "https://avatars.mds.yandex.net/get-kinopoisk-image/4303601/0e569ebd-0639-416b-92c5-2afffbd5d089/600x900",
            "Хоббит: Нежданное путешествие",
            true,
            8.1,
            "fourth film"
        ),
        FilmDataResponse(
            "https://avatars.mds.yandex.net/get-kinopoisk-image/6201401/dd195023-81e0-42bc-9b33-e86ac8abf30e/600x900",
            "Хоббит: Пустошь Смауга",
            true,
            8.0,
            "fifth film"
        ),
        FilmDataResponse(
            "https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/ee1276c4-6e67-45cd-94db-8bd47bb21da4/600x900",
            "Хоббит: Битва пяти воинств",
            true,
            7.9,
            "six film"
        )
    )
}