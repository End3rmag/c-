package com.example.pokemonapp.data.repository

import com.example.pokemonapp.data.Model.PokemonItemsResponse
import com.example.pokemonapp.data.Network.PokemonServiceIplimentation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class PokemoRepository(val pokemonServiceIplimentation: PokemonServiceIplimentation) {
    fun getPokemons() : Flow<Response<PokemonItemsResponse>> = flow{
        emit(pokemonServiceIplimentation.getPokemons())

    }
}