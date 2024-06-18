package com.example.pokemonapp.ui.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.pokemonapp.data.Model.PokemonItemResponse
import com.example.pokemonapp.data.PokemonApplication
import com.example.pokemonapp.data.repository.PokemoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenViewModel(private val repository: PokemoRepository):ViewModel() {
    private val _stateMainScreen = MutableStateFlow(MainScreenState())
    val stateMainScreen = _stateMainScreen.asStateFlow()

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
        viewModelScope.launch {
            repository.getPokemons().collect{ result ->
                if (result.isSuccessful){
                    val pokemonItemsResponse = result.body()
                    _stateMainScreen.update { it.copy(isLoading = false, pokemonList = pokemonItemsResponse!!.results) }
                }
                else{
                            _stateMainScreen.update {
                                it.copy(isLoading = false ,isError = true)}
                }
            }
        }
    }
    companion object{
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                return  MainScreenViewModel((application as PokemonApplication).repository) as T
            }
        }
    }
}
