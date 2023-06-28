package com.example.tpqualiteair.ui

import android.text.Spannable.Factory
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.tpqualiteair.bo.Ville
import com.example.tpqualiteair.dao.VilleDAO
import com.example.tpqualiteair.db.AppDataBase
import kotlinx.coroutines.launch

class VilleViewModel (private val villeDAO: VilleDAO):ViewModel(){

    var villes = MutableLiveData<List<Ville>>()


    fun addVille(ville: Ville):MutableLiveData<Long>{
        val id = MutableLiveData<Long>()
        viewModelScope.launch {
            id.value=villeDAO.insert(ville)
        }
        return id

    }

    fun getAll(){

        viewModelScope.launch {

           villes.value=villeDAO.getAll()
            Log.i("testAll", "getAll: "+villes.value.toString())

        }

    }





    companion object{

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val application= checkNotNull(extras[APPLICATION_KEY])

                return VilleViewModel(
                    (AppDataBase.getInstance(application.applicationContext)).getVilleDAO()
                )as T
            }

        }

    }

}