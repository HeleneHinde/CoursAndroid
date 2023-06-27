package com.example.mod8viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {


    var counter : MutableLiveData<Int> = MutableLiveData<Int>(0)

    fun increment() {
        counter.value=counter.value?.inc()

    }

/*    fun getCounter(): Int? {

        return counter.value
    }*/



}