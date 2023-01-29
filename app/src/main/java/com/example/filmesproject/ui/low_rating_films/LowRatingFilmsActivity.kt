package com.example.filmesproject.ui.low_rating_films

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmesproject.R
import com.example.filmesproject.domain.models.FilmData
import com.example.filmesproject.ui.low_rating_films.presenter.LowRatingFilmsPresenter
import com.example.filmesproject.ui.low_rating_films.presenter.LowRatingFilmsPresenterImpl
import com.example.filmesproject.ui.DescriptionFragment
import com.example.filmesproject.ui.FilmAdapter

class LowRatingFilmsActivity : AppCompatActivity(), LowRatingFilmsView {
    private var presenter: LowRatingFilmsPresenter? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_low_rating_films)

        presenter = LowRatingFilmsPresenterImpl(this)
        presenter?.getLowRatingFilms()
    }

    override fun showLowRatingFilms(films: List<FilmData>) {
        val recycler = findViewById<RecyclerView>(R.id.rvFilmList)
        val itemClick: (name: String, description: String) -> Unit = { name, description ->
            val messageFragment = DescriptionFragment().newInstance(name, description)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout, messageFragment)
                .addToBackStack("Fragment")
                .commit()
        }
        val adapter = FilmAdapter(itemClick)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter?.setItems(films)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) super.onBackPressed()
        else supportFragmentManager.popBackStack()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onClear()
    }
}