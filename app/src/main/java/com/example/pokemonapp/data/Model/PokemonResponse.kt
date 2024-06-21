package com.example.pokemonapp.data.Model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val id:Int,
    val name:String,
    val height: Int,
    val order:Int,
    val weight:Int,
    val species: UrlResource,
    val types: List<TypesResource>,
    val abilities: List<AbilitiesResponse>,
    val stats : List<StatsResponse>,
    val sprites:SpritesResponse
)

data class AbilitiesResponse(
    val ability: UrlResource
)
data class SpritesResponse(
    val other: OfficialSpritesResponse
)
data class OfficialSpritesResponse(
    @SerializedName("official-artwork")
    val official_artwork : OfficialArtWorkResponse
)
data class OfficialArtWorkResponse(
    val front_default: String,
    val front_shiny: String
)

data class StatsResponse(
    val base_stat : Int,
    val stat: UrlResource
)
data class UrlResource(
    val name: String,
    val url: String)

data class TypesResource(
    val slot : Int,
    val type : UrlResource
)

