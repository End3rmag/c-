package com.example.pokemonapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R
import com.example.pokemonapp.data.Model.PokemonItemResponse

class PokemonAdapter(private val pokemons: List<PokemonItemResponse>) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val PokemonImage = view.findViewById<ImageView>(R.id.PokemonImage)
        val PokemonNumber = view.findViewById<TextView>(R.id.PokemonNumber)
        val PokemonName = view.findViewById<TextView>(R.id.PokemonName)

        fun bind(pokemon:PokemonItemResponse){
            PokemonImage.setImageResource(R.drawable._b3a8bec29962d2348bfe5ddc97cdee2)
            PokemonName.text = "999"
            PokemonName.text = pokemon.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = pokemons.size



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons.get(position)
        holder.bind(pokemon)
    }
}