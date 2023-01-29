package com.example.filmesproject.ui.films

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmesproject.R
import com.example.filmesproject.data.FilmDataResponseImpl
import com.example.filmesproject.data.models.FilmDataResponse
import com.example.filmesproject.ui.films.presenter.FilmPresenter
import com.example.filmesproject.ui.films.presenter.FilmPresenterImpl
import com.example.filmesproject.ui.low_rating_films.LowRatingFilmsActivity
import com.example.filmesproject.ui.DescriptionFragment
import com.example.filmesproject.ui.FilmAdapter

class MainActivity : AppCompatActivity(), FilmView {
    private var presenter: FilmPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randomIntent = Intent(this, LowRatingFilmsActivity::class.java)
        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            startActivity(randomIntent)
        }

        presenter = FilmPresenterImpl(this)
        presenter?.getFilms()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) super.onBackPressed()
        else supportFragmentManager.popBackStack()
    }

    override fun showFilms(films: List<FilmDataResponse>) {
        val recycler = findViewById<RecyclerView>(R.id.rvFilmList)
        val itemClick: (name: String, description: String) -> Unit = { name, description ->
            val messageFragment = DescriptionFragment().newInstance(name, description)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frameLayout, messageFragment)
                .addToBackStack("Fragment")
                .commit()
        }
        val adapter = FilmAdapter(itemClick)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val films = FilmDataResponseImpl().getFilms()
        adapter.setItems(films)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onClear()
    }
}