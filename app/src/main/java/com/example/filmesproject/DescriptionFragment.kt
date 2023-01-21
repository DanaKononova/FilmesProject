package com.example.filmesproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DescriptionFragment(): Fragment() {
    companion object {
        private val KEY_TEXT = "some_text"
        private val NAME_TEXT = "name_text"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.description, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = view.findViewById<TextView>(R.id.filmName)
        name.text = arguments?.getString(NAME_TEXT) ?: return
        val description = view.findViewById<TextView>(R.id.description)
        description.text = arguments?.getString(KEY_TEXT) ?: return
    }
    fun newInstance(name:String, text:String): DescriptionFragment {
        val fragment = DescriptionFragment()
        val args: Bundle = Bundle()
        args.putString(NAME_TEXT, name)
        args.putString(KEY_TEXT, text)
        fragment.arguments = args
        return fragment
    }

}