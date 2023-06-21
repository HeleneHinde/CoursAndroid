package com.example.mod4databinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mod4databinding.R
import com.example.mod4databinding.bo.User
import com.example.mod4databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



      binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)


        val user = User("Camille", "Hervé",4)
        var i = 0

        binding.user = user

        binding.button.setOnClickListener {
            binding.textView.text=""+ ++i
        }

    }
}