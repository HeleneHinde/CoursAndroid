package com.example.mod8viewmodel

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {


    private var counter : Int = 0

    fun increment():Int{
        return ++counter
    }

    fun getCounter():Int{

        return counter
    }



}