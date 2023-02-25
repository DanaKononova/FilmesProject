package com.example.filmesproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmesproject.R
import com.example.filmesproject.databinding.FragmentMainBinding
import com.example.filmesproject.data.FilmDataRepositoryImpl
import com.example.filmesproject.data.Server
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class FilmMainFragment: Fragment() {
    private val viewModel by viewModels<FilmViewModel>()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycler = binding.rvFilmList
        val favButton = view.findViewById<Button>(R.id.bt_favFilm)
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

        favButton.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val favFilm = FilmDataRepositoryImpl.getFavouriteFilm()
                Toast.makeText(requireContext(), favFilm.name, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}