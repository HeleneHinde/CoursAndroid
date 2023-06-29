package com.example.tpfinalpkm.bo

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

/*@Entity
@Parcelize
data class StatsPokemon (    val HP: Int,
                             val attack: Int,
                             val defense: Int,
                             val special_attack: Int,
                             val special_defense: Int,
                             val speed: Int) : Parcelable

@Entity
@Parcelize
data class PokemonType(  val name: String,  val image: String) : Parcelable*/


@Entity
@Parcelize
data class Pokemon(@PrimaryKey(autoGenerate = true)var id : Int, @Json(name="name") var nom : String, var image : String)// var stats: StatsPokemon, val apiTypes: List<PokemonType>) :
    : Parcelable

