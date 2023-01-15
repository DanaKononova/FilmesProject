package com.example.filmesproject

import android.annotation.SuppressLint
import androidx.annotation.StringRes

@SuppressLint("SupportAnnotationUsage")
data class FilmData(
    val poster: String,
    @StringRes val name: String,
    val hasOskar: Boolean,
    val rating: Double
)