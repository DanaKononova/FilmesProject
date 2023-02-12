package com.example.filmesproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmesproject.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmMainFragment: Fragment() {
    private val viewModel by viewModels<FilmViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = view.findViewById<RecyclerView>(R.id.rvFilmList)
        val itemClick: (String, String) -> Unit = { name, description ->
            val action = FilmMainFragmentDirections.actionMainFragmentToDescriptionFragment(name, description)
            findNavController().navigate(action)
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            val adapter = FilmAdapter(it, itemClick)
            recycler.adapter = adapter
            recycler.layoutManager =
                LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        }

        viewModel.getData()

    }
}