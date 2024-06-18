package com.example.pokemonapp.data.Model

data class PokemonItemsResponse(
    val count : Int,
    val next : String?,
    val  prvious:String?,
    val results : List<PokemonItemResponse>
)
data class PokemonItemResponse(
    val name : String,
    val url : String
)