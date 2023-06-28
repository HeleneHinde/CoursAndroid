package com.example.tpqualiteair.bo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ville(    @PrimaryKey(autoGenerate = true) val id : Long = 0,var nom :String, var note : Float)
