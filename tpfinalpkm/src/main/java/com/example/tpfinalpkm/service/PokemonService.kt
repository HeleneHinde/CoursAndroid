package com.example.tpfinalpkm.service

import com.example.tpfinalpkm.bo.Pokemon
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    companion object{

        var BASE_URL = "https://pokebuildapi.fr/api/v1/"

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        //librairie qui permet de lancer nos appels aux api
        val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL).build()
    }

    @GET("pokemon")
    suspend fun getAll():List<Pokemon>

    @GET("pokemon/{id}")
    suspend fun getById(@Path("id") id : Int):Pokemon

    object PokemonAPI{
        val retrofitService : PokemonService by lazy { retrofit.create(PokemonService::class.java) }

    }


}