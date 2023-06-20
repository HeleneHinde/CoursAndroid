package com.example.mod3lib

import java.math.BigInteger
import java.util.*

fun main() {

    val nbCases = 64
    var grain = BigInteger.ONE
    var case = 1

    while (case<=nbCases){
        grain =grain.multiply(BigInteger.TWO)
        println(grain)
        case++


    }
    println(grain)






}