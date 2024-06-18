package com.example.pokemonapp.data.Network

import com.example.pokemonapp.data.Model.PokemonItemsResponse
import retrofit2.Response

class PokemonServiceIplimentation(val pokemonApi: PokemonApi) {
   suspend fun getPokemons(): Response<PokemonItemsResponse> = pokemonApi.getPokemons()
}