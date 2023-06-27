package com.example.mod9ormroom.bo

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class Type {
    BOARD,
    DECK_BUILDING,
    CARDS,
    COOP
}

enum class Theme {
    FANTASTIC,
    WESTERN,
    SF,
    HORROR,
    KIDS
}

@Entity
data class BoardGame(
    val name : String,
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val nbPlayerMin : Int,
    val nbPlayerMax : Int,
    val type : Type,
    val theme : Theme
)
