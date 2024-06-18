package com.example.pokemonapp.data.Network

import com.example.pokemonapp.data.Model.PokemonItemsResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {
    @GET("api/v2/pokemon")
    suspend fun getPokemons() : Response<PokemonItemsResponse>
}
