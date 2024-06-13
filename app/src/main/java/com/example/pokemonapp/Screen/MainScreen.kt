package com.example.pokemonapp.Screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.pokemonapp.R


class MainScreen : Fragment(R.layout.fragment_activity){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view
            .findViewById<Button>(R.id.NavigateButton)
        button.setOnClickListener {
            parentFragmentManager.commit { replace<AboutScreen>(R.id.Host_fragment) }
        }
    }
}
