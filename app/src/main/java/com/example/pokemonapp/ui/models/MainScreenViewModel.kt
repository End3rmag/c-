package com.example.pokemonapp.ui.models

import android.app.Application
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.ChangeStateFragmentDialog
import com.example.pokemonapp.R
import com.example.pokemonapp.data.Model.PokemonResponse
import com.example.pokemonapp.data.PokemonApplication
import com.example.pokemonapp.ui.Screen.AboutScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenViewModel(application: Application):AndroidViewModel(application) {
    private val repository by lazy {(application as PokemonApplication).repository}
    private val _stateMainScreen = MutableStateFlow(MainScreenState())
    val stateMainScreen = _stateMainScreen.asStateFlow()

    private val _stateAboutScreen = MutableStateFlow(AboutScreenState())
    val stateAboutScreen = _stateAboutScreen.asStateFlow()


    private var _fragmentManager:FragmentManager? = null

    fun selectPokemon(pokemonResponse: PokemonResponse){
        val pokemonSpecies = repository.getSpeciesByName(pokemonResponse.name)
        viewModelScope.launch {
            pokemonSpecies.collect{resp ->
                _stateAboutScreen.update { it.copy(color = resp.color.name, pokemonResponse = pokemonResponse) }
            }
        }
    }

    fun changeStateSort(state: MainScreenStateSort){
        when(state){
            MainScreenStateSort.NAME -> {
                _stateMainScreen.update {
                    it.copy(isNameSorted = true, isNumberSorted = false)
                }
            }
            MainScreenStateSort.NUMBER ->{
                _stateMainScreen.update {
                    it.copy(isNumberSorted = true, isNameSorted = false)
                }
            }
        }
    }
    fun getPokemons() {
        _stateMainScreen.update { it.copy(isLoading = true) }
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPokemons().collect{ result ->
                    _stateMainScreen.update { it.copy(isLoading = false, pokemonList = result) }
            }
        }
    }

    fun setFragmentManager(fragmentManager: FragmentManager){
        _fragmentManager = fragmentManager
    }
    fun navigateToAboutScreen(){
        _fragmentManager?.commit {
            replace<AboutScreen>(R.id.Host_fragment)
            addToBackStack(null)
        }
    }

    fun showStateDialog(childFragmentManager: FragmentManager){
        val dialog = ChangeStateFragmentDialog()
        dialog.show(childFragmentManager, "ChangeStateDialog")
    }


}
