package com.example.filmesproject.data.mapper

import com.example.filmesproject.data.models.FilmDataResponse
import com.example.filmesproject.domain.models.FilmData
import javax.inject.Inject

class FilmMapper @Inject constructor(){
    operator fun invoke(response: FilmDataResponse) = with(response) {
        FilmData(
            poster = poster ?: "",
            name = name ?: "",
            hasOskar = hasOskar ?: false,
            rating = rating ?: 0.0,
            description = description ?: ""
        )
    }
}