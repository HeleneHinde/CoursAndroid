package com.example.mod8viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mod8viewmodel.databinding.ActivityMainBinding


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var vm : CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        vm = ViewModelProvider(this)[CounterViewModel::class.java]

        binding.vm = vm

        binding.button.setOnClickListener {

            vm.increment()
            binding.vm = vm

        }
        Log.i(TAG, "onCreate: ")

    }

}