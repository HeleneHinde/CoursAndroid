package com.example.mod12api.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mod12api.bo.Joke
import com.example.mod12api.service.ChuckService
import kotlinx.coroutines.launch

class ChuckViewModel:ViewModel() {

    var joke = MutableLiveData<Joke>()

            fun getRandomJoke(){
                viewModelScope.launch {

                    joke.value = ChuckService.ChuckAPI.retrofitService.getrandomJoke()

                }

            }

}