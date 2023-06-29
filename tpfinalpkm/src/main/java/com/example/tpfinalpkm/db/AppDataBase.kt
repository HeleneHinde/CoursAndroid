package com.example.tpfinalpkm.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tpfinalpkm.bo.Pokemon
/*import com.example.tpfinalpkm.bo.PokemonType
import com.example.tpfinalpkm.bo.StatsPokemon*/
import com.example.tpfinalpkm.dao.PokemonDAO


@Database(entities = [Pokemon::class/*, StatsPokemon::class, PokemonType::class*/], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getPokemonDAO():PokemonDAO


    companion object{


        private var INSTANCE : AppDataBase?=null

        fun getInstance(context : Context): AppDataBase{
            var instance = INSTANCE

            if (instance==null){

                instance= Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "Pokemon"
                ).fallbackToDestructiveMigration().build()

                INSTANCE=instance

            }
            return instance

        }



    }


}