package com.example.mod9ormroom.dao

import androidx.room.*
import com.example.mod9ormroom.bo.BoardGame

@Dao
interface BoardGameDAO {

    @Insert
    suspend fun insert(boardGame : BoardGame) : Long

    @Update
    suspend fun update(boardGame : BoardGame)

    @Delete
    suspend fun delete(boardGame : BoardGame)

    @Query("SELECT * from BoardGame WHERE id= :id")
    suspend fun getById(id :Long) : BoardGame

    @Query("SELECT * from BoardGame")
    suspend  fun getAll() : List<BoardGame>


}