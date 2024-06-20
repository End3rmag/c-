package com.example.pokemonapp.data

import android.app.Application
import androidx.fragment.app.FragmentManager
import com.example.pokemonapp.NavController
import com.example.pokemonapp.data.Network.PokemonService
import com.example.pokemonapp.data.Network.PokemonServiceIplimentation
import com.example.pokemonapp.data.repository.PokemoRepository
import com.example.pokemonapp.ui.MainActivity

class PokemonApplication: Application() {
    private val pokemonServiceIplimentation = PokemonServiceIplimentation(PokemonService.PokemonService)
    val repository = PokemoRepository(pokemonServiceIplimentation)

}
