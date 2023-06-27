package com.example.mod9ormroom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mod9ormroom.bo.BoardGame
import com.example.mod9ormroom.dao.BoardGameDAO

@Database(entities = [BoardGame::class], version = 1)
abstract class AppDataBase : RoomDatabase() {


    //liste des DAO

    abstract fun getBoardGameDAO():BoardGameDAO

    companion object{

        private var INSTANCE : AppDataBase? = null

        fun getInstance(context : Context) : AppDataBase{
            var instance = INSTANCE

            //DataBaseBuilder permet de construire des objets complexes à partir d'un "moule" de base,
            //j'appelle ensuite des méthodes pour ajouter des éléments à mon objet
            if (instance==null){
                instance = Room.databaseBuilder(
                    //Permet de récupérer le nom du package de l'application pour ranger correctement la base
                    context,
                    //type de bdd
                    AppDataBase::class.java,
                    // nom de la bdd
                    "Game"
                //Permet de supprimer l'ancienne bdd lors d'un changement de version
                ).fallbackToDestructiveMigration()
                    //permet de construire l'objet final
                    .build()

                INSTANCE=instance

            }
            return instance
        }

    }

}