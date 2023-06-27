package com.example.mod9ormroom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels

import com.example.mod9ormroom.R
import com.example.mod9ormroom.bo.BoardGame
import com.example.mod9ormroom.bo.Theme
import com.example.mod9ormroom.bo.Type

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private val vm : BoardGameViewModel by viewModels { BoardGameViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Ne fonctionne plus à cause de l'injection de dépendance
       // vm = ViewModelProvider(this)[BoardGameViewModel::class.java]
        val game = BoardGame("Dixit",0,3,8, Type.CARDS, Theme.FANTASTIC)
        vm.addGame(game).observe(this){
            vm.getGame(it)
            vm.boardGame.observe(this){
                Log.i(TAG, "onCreate: "+it)
            }
        }




    }
}