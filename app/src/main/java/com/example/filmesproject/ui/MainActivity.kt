package com.example.filmesproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.navigation.findNavController
import com.example.filmesproject.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController(R.id.mainFragment).popBackStack()
            }
        })
    }
//
//    override fun showFilms(films: List<FilmDataResponse>) {
//        val recycler = findViewById<RecyclerView>(R.id.rvFilmList)
//        val itemClick: (name: String, description: String) -> Unit = { name, description ->
//            val messageFragment = DescriptionFragment().newInstance(name, description)
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.frameLayout, messageFragment)
//                .addToBackStack("Fragment")
//                .commit()
//        }
//        val adapter = FilmAdapter(itemClick)
//        recycler.adapter = adapter
//        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        val films = FilmDataRepositoryImpl().getFilms()
//        adapter.setItems(films)
//    }
}