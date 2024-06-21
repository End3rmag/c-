package com.example.pokemonapp.ui.Screen

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.pokemonapp.ChangeStateFragmentDialog
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentActivityBinding
import com.example.pokemonapp.ui.adapters.PokemonAdapter
import com.example.pokemonapp.ui.models.MainScreenViewModel
import kotlinx.coroutines.launch


class MainScreen : Fragment(R.layout.fragment_activity) {
    private var mainScreenViewBinding:FragmentActivityBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel: MainScreenViewModel by activityViewModels()
        mainScreenViewBinding = FragmentActivityBinding.bind(view)
        viewModel.setFragmentManager(parentFragmentManager)
        viewModel.getPokemons()
        lifecycleScope.launch {
            viewModel.stateMainScreen.collect {
                if (it.isNumberSorted) {
                    setSortByNumber(view)
                }
                if (it.isNameSorted) {
                    setSortByName(view)
                }
                if (!it.pokemonList.isNullOrEmpty()) {
                    val adapter = PokemonAdapter(it.pokemonList) {
                        viewModel.selectPokemon(it)
                        viewModel.navigateToAboutScreen()

                    }
                    mainScreenViewBinding?.PokemonList?.adapter = adapter
                }
            }
        }
        viewModel.getPokemons()

        mainScreenViewBinding?.ChangeMode?.setOnClickListener{
            viewModel.showStateDialog(childFragmentManager)
        }


    }

    fun setSortByName(view:View){
        val imageButton = view.findViewById<ImageButton>(R.id.ChangeMode)
        imageButton.setImageResource(R.drawable.text_format)}

    fun setSortByNumber(view: View){
        val imageButton=view.findViewById<ImageButton>(R.id.ChangeMode)
        imageButton.setImageResource(R.drawable.tag_ic)
    }
}


