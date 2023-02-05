package com.example.filmesproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.filmesproject.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DescriptionFragment() : Fragment() {
    private val args: DescriptionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_description, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = view.findViewById<TextView>(R.id.tv_name)
        name.text = args.filmName
        val description = view.findViewById<TextView>(R.id.tv_description)
        description.text = args.description
    }
}