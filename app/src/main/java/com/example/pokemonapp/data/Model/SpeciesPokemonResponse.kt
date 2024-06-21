package com.example.pokemonapp.data.Model

data class SpeciesPokemonResponse(
    val color : UrlResource,
    val flavor_text_entries: List<Flavor_text>
)

data class Flavor_text(
    val flavor_text : String,
    val language : UrlResource

)
