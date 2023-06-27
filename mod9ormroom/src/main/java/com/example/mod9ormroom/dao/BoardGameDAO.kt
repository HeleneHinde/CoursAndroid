package com.example.mod9ormroom.dao

import androidx.room.*
import com.example.mod9ormroom.bo.BoardGame

@Dao
interface BoardGameDAO {

    @Insert
    fun insert(boardGame : BoardGame) : Long

    @Update
    fun update(boardGame : BoardGame)

    @Delete
    fun delete(boardGame : BoardGame)

    @Query("SELECT * from BoardGame WHERE id= :id")
    fun getById(id :Long) : BoardGame

    @Query("SELECT * from BoardGame")
    fun getAll() : List<BoardGame>


}