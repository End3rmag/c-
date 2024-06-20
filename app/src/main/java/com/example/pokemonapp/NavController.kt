package com.example.pokemonapp

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.pokemonapp.data.Model.PokemonResponse
import com.example.pokemonapp.ui.Screen.AboutScreen

class NavController: FragmentManager() {
    fun navigateToAboutScreen(){
        commit {
             add<AboutScreen>(R.id.Host_fragment)

        }
    }
}