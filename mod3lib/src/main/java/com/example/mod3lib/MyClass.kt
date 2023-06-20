package com.example.mod3lib

var hello = "bonjour"

/*

// les basics
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

    //gestion null implicite ou explicite
    var mot2:String?=null
    // le ? permet de faire un "safe call", si la valeur n'est pas null, alors on appelle la fonction lenght, sinon retourne null (mais pas de nullpointer
    println(mot2?.length)
    // avec le double !! on force l'appelle de la fonction lenght, si la variable est null alors on soulève un nullpointerException
    println(mot!!.length)
    mot2="camille"
    println(mot2.length)


}*/

/*
//les structures de controle
fun main(){

    //if

    var age = 18

    var message = if (age>=18){
        "majeur!"
    }else {
        "mineur !"
    }

    println(message)
    //le when correspond au switch case en java
    when (age){
        1,2-> println("c'est un bébé !")
        in 3..18-> println("c'est un enfant")
        is Int-> println("c'est un adulte")
        else -> println("c'est autre chose")
    }

    when(message){
        "majeur!","mineur !"-> println("c'est ok")


    }

    var pays = arrayOf("Belgique", "Maroc", "Japon")

    //la fonction .plus renvoi un nouveau tableau avec l'ajout de la nouvelle donnée, il faut donc écraser l'ancien
    pays = pays.plus("Chili")

    //deux manière de récupérer la valeur à travers son index
    println(pays[0])
    println(pays.get(0))

    for (p in pays){
        println(p)

    }

    for ((k,p) in pays.withIndex()){
        println("$k : $p")

    }


}*/

//Fonctions, extension, elvis, prédicat (expresson fléchée)

fun main() {
    //extension : rajouter une méthode à une classe en dehors de la classe

    fun String.sayHello() {
        println("Hello $this")

    }

    "Camille".sayHello();

    fun Int.multiply(number: Int): Int {
        return this * number
    }
    println(12.multiply(5))

    //Elvis

    var name : String? = null

    val taille = name?.length?:"toto"

    println(taille)

    //List

    val colors = mutableListOf<String>("jaune")
    colors.add("violet")
    colors.add("vert")

    println(colors.toString())

    //list qui ne peux changer (on ne peut pas faire de add
    val colors2 = listOf<String>("rose", "cornflowerblue", "chartreuse")

    //la fonction .plus ajoute à la liste un élément et renvoi une nouvelle liste
    val colors3 = colors2.plus("rouge")

    println(colors2 + colors3)

    //truc = truc2
    val truc = colors3.filter { it.length>4 }.forEach {println(it)}
    val truc2 = colors3.filter { color->color.length>4 }.forEach { michel ->println(michel)}

    println(colors3.filter { it.length>4 }.count())

}
