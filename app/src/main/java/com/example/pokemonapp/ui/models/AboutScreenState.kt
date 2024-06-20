package com.example.pokemonapp.ui.models

import android.content.res.Resources
import com.example.pokemonapp.R
import com.example.pokemonapp.data.Model.PokemonResponse

data class AboutScreenState(
    val color: Int = R.color.white,
    val pokemonResponse: PokemonResponse? = null

)
