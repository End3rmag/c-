package com.example.pokemonapp.ui.models

import com.example.pokemonapp.data.Model.PokemonItemResponse
import com.example.pokemonapp.data.Model.PokemonResponse

data class MainScreenState (
    var isNumberSorted: Boolean = true,
    var isNameSorted: Boolean = false,
    val isLoading: Boolean = false,
    val isError : Boolean = false,
    val searchText: String = "",
    val pokemonList:List<PokemonResponse> = emptyList()

)
