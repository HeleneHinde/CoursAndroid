package com.example.tpqualiteair.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tpqualiteair.bo.Ville
import com.example.tpqualiteair.dao.VilleDAO

@Database(entities = [Ville::class], version=1)
abstract class AppDataBase:RoomDatabase(){

    abstract fun getVilleDAO():VilleDAO

    companion object{


        private var INSTANCE : AppDataBase? = null

        fun getInstance(context : Context): AppDataBase{
            var instance = INSTANCE

            if (instance==null){

                instance= Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "Qualite"
                ).fallbackToDestructiveMigration().build()

                INSTANCE=instance

            }
            return instance

        }

    }


}