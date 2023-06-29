package com.example.tpfinalpkm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.tpfinalpkm.bo.Pokemon
import com.example.tpfinalpkm.dao.PokemonDAO
import com.example.tpfinalpkm.db.AppDataBase
import com.example.tpfinalpkm.service.PokemonService
import kotlinx.coroutines.launch

class PokemonViewModel(private val pokemonDAO : PokemonDAO):ViewModel() {

    var listPokemon = MutableLiveData<List<Pokemon>>()

    var pokemon = MutableLiveData<Pokemon>()

    fun getPokemon(id : Int){
        viewModelScope.launch {

            pokemon.value = PokemonService.PokemonAPI.retrofitService.getById(id)

        }

    }

    fun getAll(){
        viewModelScope.launch {

            listPokemon.value = PokemonService.PokemonAPI.retrofitService.getAll()

        }

    }


    fun addPokemon(pokemon: Pokemon):MutableLiveData<Long>{
        val id = MutableLiveData<Long>()
        viewModelScope.launch {
            id.value= pokemonDAO.insert(pokemon)
        }
        return id

    }

    companion object{

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val application= checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])

                return PokemonViewModel(
                    (AppDataBase.getInstance(application.applicationContext)).getPokemonDAO()
                )as T
            }

        }

    }

}