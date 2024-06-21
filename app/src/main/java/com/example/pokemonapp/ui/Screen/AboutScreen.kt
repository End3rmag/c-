package com.example.pokemonapp.ui.Screen

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.pokemonapp.R
import com.example.pokemonapp.data.Model.PokemonResponse
import com.example.pokemonapp.data.Model.TypeModel
import com.example.pokemonapp.databinding.FragmentScreenBinding
import com.example.pokemonapp.ui.adapters.TypeAdapter
import com.example.pokemonapp.ui.models.MainScreenViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class AboutScreen : Fragment(R.layout.fragment_screen) {
    private var aboutScreenBinding : FragmentScreenBinding? = null
    private val viewModel : MainScreenViewModel by activityViewModels()
    private val mapColor: MutableMap<String, Int> = mutableMapOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        aboutScreenBinding = FragmentScreenBinding.bind(view)
        initColor()
        lifecycleScope.launch {
            viewModel.stateAboutScreen.collect{
                state -> state.pokemonResponse?.let{pokemon -> setPokemon(pokemonResponse = pokemon)}
            }
        }
    }

    fun setPokemon(pokemonResponse: PokemonResponse){
        val typeAdapter = TypeAdapter(pokemonResponse.types.map {
            mapColor[it.type.name].let {color ->
                TypeModel(color!!, it.type.name)
            }
        })
        val color = mapColor[pokemonResponse.types[0].type.name]
        if(color != null){
            setGlobalColor(color)
        }
        if(aboutScreenBinding != null) {
            aboutScreenBinding!!.apply {
                PokemonType.adapter = typeAdapter
                PokemonImageView.load(pokemonResponse.sprites.other.official_artwork.front_default)
                PokemonNameTitle.text = pokemonResponse.name
                PokemonNumberTitle.text = pokemonResponse.order.toString()
                WeightTextView.text = pokemonResponse.weight.toString()
                HeightTextView.text = pokemonResponse.height.toString()
                Ability1.text = pokemonResponse.abilities[0].ability.name
                Ability2.text = pokemonResponse.abilities[1].ability.name

            }
        }
    }
    fun setGlobalColor(color: Int){
        if(aboutScreenBinding != null){
            aboutScreenBinding?.MainLayout?.setBackgroundColor(color)
            aboutScreenBinding?.PokemonStats?.setBackgroundColor(color)
            aboutScreenBinding?.BaseStats?.setTextColor(color)
            aboutScreenBinding?.AboutTitle?.setTextColor(color)
        }
    }

    fun initColor(){
        mapColor.set("white",requireContext().getColor(R.color.white) )
        mapColor.set("grass", requireContext().getColor(R.color.Grass))
        mapColor.set("bug",requireContext().getColor(R.color.Bug))
        mapColor.set("dark",requireContext().getColor(R.color.Dark))
        mapColor.set("dragon",requireContext().getColor(R.color.Dragon))
        mapColor.set("electric",requireContext().getColor(R.color.Electric))
        mapColor.set("fairy",requireContext().getColor(R.color.Fairy))
        mapColor.set("fighting",requireContext().getColor(R.color.Fighting))
        mapColor.set("fire",requireContext().getColor(R.color.Fire))
        mapColor.set("flying",requireContext().getColor(R.color.Flying))
        mapColor.set("ghost",requireContext().getColor(R.color.Ghost))
        mapColor.set("normal",requireContext().getColor(R.color.Normal))
        mapColor.set("ground",requireContext().getColor(R.color.Ground))
        mapColor.set("ice",requireContext().getColor(R.color.Ice))
        mapColor.set("poison",requireContext().getColor(R.color.Poison))
        mapColor.set("psychic",requireContext().getColor(R.color.Psychic))
        mapColor.set("rock",requireContext().getColor(R.color.Rock))
        mapColor.set("steel",requireContext().getColor(R.color.Steel))
        mapColor.set("water",requireContext().getColor(R.color.Water))


    }
}