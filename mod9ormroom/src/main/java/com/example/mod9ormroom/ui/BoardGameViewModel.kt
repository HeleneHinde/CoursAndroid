package com.example.mod9ormroom.ui

import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mod9ormroom.bo.BoardGame
import com.example.mod9ormroom.dao.BoardGameDAO
import com.example.mod9ormroom.db.AppDataBase
import kotlinx.coroutines.launch

//injection de dépendance de la calsse DAO
class BoardGameViewModel(private val boardGameDAO: BoardGameDAO) : ViewModel() {

    var boardGame = MutableLiveData<BoardGame>(null)

    fun addGame(boardGame:BoardGame):MutableLiveData<Long>{
        var id = MutableLiveData<Long>()
        viewModelScope.launch {
            id.value=boardGameDAO.insert(boardGame)
        }
        return id
    }

    fun getGame(id:Long){
        viewModelScope.launch {
            boardGame.value=boardGameDAO.getById(id)
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])

                //Instanciation du ViewModel en prenant en compte l'ajut de la DAO dans le constructeur
                return BoardGameViewModel(
                    (AppDataBase.getInstance(application.applicationContext)).getBoardGameDAO()
                ) as T
            }
        }
    }

}