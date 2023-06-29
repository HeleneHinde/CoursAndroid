package com.example.tpfinalpkm.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.tpfinalpkm.bo.Pokemon

@Dao
interface PokemonDAO {

    @Insert
    suspend fun insert(pokemon: Pokemon):Long




}