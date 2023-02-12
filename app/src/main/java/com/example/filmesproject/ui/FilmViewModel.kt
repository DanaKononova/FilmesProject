package com.example.filmesproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmesproject.domain.models.FilmData
import com.example.filmesproject.domain.repository.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    private val repository: FilmRepository
): ViewModel() {

    private val _liveData = MutableLiveData<List<FilmData>>()
    val liveData: LiveData<List<FilmData>> get() = _liveData

    fun getData(){
        _liveData.value = repository.getFilms()
    }
}