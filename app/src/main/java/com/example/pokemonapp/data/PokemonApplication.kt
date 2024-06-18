package com.example.pokemonapp.data

import android.app.Application
import com.example.pokemonapp.data.Network.PokemonService
import com.example.pokemonapp.data.Network.PokemonServiceIplimentation
import com.example.pokemonapp.data.repository.PokemoRepository

class PokemonApplication: Application() {
    private val pokemonServiceIplimentation = PokemonServiceIplimentation(PokemonService.PokemonService)
    val repository = PokemoRepository(pokemonServiceIplimentation)
}
