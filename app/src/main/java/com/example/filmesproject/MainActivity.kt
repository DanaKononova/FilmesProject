package com.example.filmesproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmesproject.model.FilmRepositoryImpl
import com.example.filmesproject.model.models.UnionType
import com.example.filmesproject.presenter.FilmPresenter
import com.example.filmesproject.presenter.FilmPresenterImpl
import com.example.filmesproject.user_interface.DescriptionFragment
import com.example.filmesproject.user_interface.FilmAdapter
import com.example.filmesproject.user_interface.FilmView

class MainActivity : AppCompatActivity(), FilmView {
    private var presenter: FilmPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = FilmPresenterImpl(this)
        presenter?.getFilms()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) super.onBackPressed()
        else supportFragmentManager.popBackStack()
    }

    override fun showFilms(films: List<UnionType>) {
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
        val films = FilmRepositoryImpl().getFilms()
        adapter.setItems(films)

        val androidListNew = Server.getFilms()
        adapter.setItems(androidListNew)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onClear()
    }
}