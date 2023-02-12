package com.example.filmesproject.di

import com.example.filmesproject.data.FilmDataRepositoryImpl
import com.example.filmesproject.domain.repository.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FilmDataModule {
    @Binds
    abstract fun getFilmRepository(impl: FilmDataRepositoryImpl): FilmRepository
}