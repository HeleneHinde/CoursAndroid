package com.example.mod3lib

var hello = "bonjour"

fun main(){
    hello = "hello"
    println(hello)

    //constante avec val et déclaration de type
    val value = 10;

    //lazy

    var mot = "world !"
    val message by lazy {"Hello $mot"}
    mot = "toto"
    println(message)
    //quand la variable est initialisée elle garde sa valeur par la suite
    mot = "man"

    println(message)


}