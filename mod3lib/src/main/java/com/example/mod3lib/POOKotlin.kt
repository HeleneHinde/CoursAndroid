package com.example.mod3lib

class Test

open class Personne {

    private var firstname:String =""
    private var lastname:String =""

    constructor(firstname:String){
        this.firstname=firstname

    }

    constructor(firstname:String, lastname:String){
        this.firstname=firstname
        this.lastname=lastname

    }

    fun getFirstname(): String {
        return this.firstname

    }
//open permet de pouvoir modifier la fonction dans une classe enfant avec un override
    open fun getTruc(){
        println("Truc")
    }

    override fun toString(): String {
        return "Personne(firstname='$firstname', lastname='$lastname')"
    }

}

fun Test.addFun(){

    println("on ajoute un méthode à la class Test")
}

data class Personne2(var firstname: String, val lastname: String)

/*
//Peut se présenter de cette forme
class Enfant(var age:Int): Personne("Michel", "Machin") {

}*/

class Enfant : Personne{

    var age : Int = 0
    constructor(age:Int,firstname: String,lastname: String) : super(firstname, lastname){
        this.age=age
    }

    override fun toString(): String {
        return super.toString() + "Enfant(age=$age)"
    }

/*    override fun getTruc() {
        super.getTruc()
        println("un truc dans la clase enfant")
    }*/

}


fun main() {

    val test = Test()

    test.addFun()

    var p = Personne("thierry", "Henry")

    p.getTruc()
    println(p.getFirstname())

    var p2 = Personne2("Jean", "Mich-Mich")
    println(p2.lastname)
    println(p2.toString())

    p2.firstname="peach"

   // p2.lastname="" //Si val ne peut pas être mis à jour

    var e =Enfant(10,"Camille","Hervé")

    println(e.toString())
    e.getTruc()

}