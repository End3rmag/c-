package com.example.pokemonapp.data.repository

import com.example.pokemonapp.data.Model.PokemonItemsResponse
import com.example.pokemonapp.data.Model.PokemonResponse
import com.example.pokemonapp.data.Model.SpeciesPokemonResponse
import com.example.pokemonapp.data.Network.PokemonServiceIplimentation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class PokemoRepository(val pokemonServiceIplimentation: PokemonServiceIplimentation) {
    fun getPokemons() : Flow<List<PokemonResponse>> = flow{
        val result = (pokemonServiceIplimentation.getPokemons())
        val pokemonList = mutableListOf<PokemonResponse>()
        if (result.isSuccessful) {
            val pokemonItems = checkNotNull(result.body())
            pokemonItems.results.forEach{
                val pokemonResponse = pokemonServiceIplimentation.getPokemon(it.name)
                if (pokemonResponse.isSuccessful){
                    val pokemon = checkNotNull(pokemonResponse.body())
                    pokemonList.add(pokemon)
                }
            }
        }
        emit(pokemonList)

    }
    fun getSpeciesByName(name:String): Flow<SpeciesPokemonResponse> = flow {
        val result = pokemonServiceIplimentation.getSpeciesByName(name)
        if(result.isSuccessful){
            val pokemonSpecies = checkNotNull(result.body())
            emit(pokemonSpecies)
        }
    }
}