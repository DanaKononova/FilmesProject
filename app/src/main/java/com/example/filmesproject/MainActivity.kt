package com.example.filmesproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemClick: (name:String, description:String) -> Unit = {name, description ->
            val messageFragment = DescriptionFragment().newInstance(name, description)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout, messageFragment)
                .addToBackStack("Fragment")
                .commit()
        }
        val films = Server.getFilms()
        val recycler = findViewById<RecyclerView>(R.id.rvFilmList)
        val adapter = FilmAdapter(itemClick)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter.setItems(films)

        val androidListNew = Server.getFilms()
        adapter.setItems(androidListNew)
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount == 0) super.onBackPressed()
        else supportFragmentManager.popBackStack()
    }
}