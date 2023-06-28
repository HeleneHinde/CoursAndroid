package com.example.tpqualiteair.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tpqualiteair.bo.Ville

@Dao
interface VilleDAO {

    @Insert
    suspend fun insert(ville : Ville):Long

    @Query("SELECT * FROM Ville")
    suspend fun getAll():List<Ville>

    @Query("SELECT * FROM Ville WHERE id = :id")
    suspend fun getById(id:Long):Ville

}