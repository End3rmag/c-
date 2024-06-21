package com.example.pokemonapp.data.Network

import com.example.pokemonapp.data.Model.PokemonItemsResponse
import com.example.pokemonapp.data.Model.PokemonResponse
import com.example.pokemonapp.data.Model.SpeciesPokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("api/v2/pokemon/")
    suspend fun getPokemons() : Response<PokemonItemsResponse>

    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemon(@Path("name") name:String): Response<PokemonResponse>

    @GET("api/v2/pokemon-species/{name}")
    suspend fun getSpeciesByName(@Path("name") name: String): Response<SpeciesPokemonResponse>
}

