package com.example.pokemonapp.data.Network

import com.example.pokemonapp.data.Model.PokemonItemsResponse
import com.example.pokemonapp.data.Model.PokemonResponse
import retrofit2.Response

class PokemonServiceIplimentation(val pokemonApi: PokemonApi) {
   suspend fun getPokemons(): Response<PokemonItemsResponse> = pokemonApi.getPokemons()
   suspend fun getPokemon(name:String): Response<PokemonResponse> = pokemonApi.getPokemon(name)
}
