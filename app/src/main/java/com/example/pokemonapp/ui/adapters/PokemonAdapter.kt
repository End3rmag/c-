package com.example.pokemonapp.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokemonapp.R
import com.example.pokemonapp.data.Model.PokemonItemResponse
import com.example.pokemonapp.data.Model.PokemonResponse

class PokemonAdapter(private val pokemons: List<PokemonResponse>,private val onClickCard:(PokemonResponse) -> Unit) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    class ViewHolder(view:View, private val onClick : (PokemonResponse) -> Unit):RecyclerView.ViewHolder(view) {
        val PokemonImage = view.findViewById<ImageView>(R.id.PokemonImage)
        val PokemonNumber = view.findViewById<TextView>(R.id.PokemonNumber)
        val PokemonName = view.findViewById<TextView>(R.id.PokemonName)
        val PokemonCard = view.findViewById<CardView>(R.id.PokemonCard)

        fun bind(pokemon: PokemonResponse){

            PokemonImage.load(pokemon.sprites.other.official_artwork.front_default){
            }
            PokemonCard.setOnClickListener{
                onClick(pokemon)
            }
            PokemonNumber.text = pokemon.order.toString()
            PokemonName.text = pokemon.name.replaceFirstChar { it -> it.uppercase() }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item,parent,false)
        return ViewHolder(view, onClickCard)
    }

    override fun getItemCount(): Int = pokemons.size



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons.get(position)
        holder.bind(pokemon)
    }
}