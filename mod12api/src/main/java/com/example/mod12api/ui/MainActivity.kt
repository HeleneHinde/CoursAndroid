package com.example.mod12api.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.mod12api.R

class MainActivity : AppCompatActivity() {

    lateinit var vm : ChuckViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this)[ChuckViewModel::class.java]

        //lancement de la requête async
        vm.getRandomJoke()

        //écoute le changement de donnée pour faire l'affichage
        vm.joke.observe(this){
            Log.i("joke", "onCreate: "+it)

        }

    }
}