package com.example.tplancede

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.tplancede.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var vm : LancedeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        vm = ViewModelProvider(this)[LancedeViewModel::class.java]

        binding.vm=vm

        //action effectué quand les données changent
        vm.totalLance.observe(this) {

            binding.vm = vm

        }

        binding.btJ1.setOnClickListener {

            vm.setLance1()

        }

        binding.btJ2.setOnClickListener {

            vm.setLance2()

        }

        binding.btReset.setOnClickListener {

            vm.reset()

         }


    }
}