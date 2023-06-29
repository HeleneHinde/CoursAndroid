package com.example.mod12api.service

import com.example.mod12api.bo.Joke
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ChuckService {


    companion object{

        var BASE_URL = "https://chuckn.neant.be/api/"

            //convertisseur intégré dans retrofit permet de transformer le JSON en objet et inversement
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        //librairie qui permet de lancer nos appels aux api
        val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL).build()

    }
    @GET("rand")
    suspend fun getrandomJoke() : Joke

    @GET("joke/{id}")
    suspend fun getJokeById(@Path("id") id : Int) : Joke

    object ChuckAPI{
        //permet de renvoyer une instance d'un objet qui implémente l'interface
        //lazy permet d'initialiser la variable uniquement si je m'en sers
        val retrofitService : ChuckService by lazy { retrofit.create(ChuckService::class.java) }

    }

}

