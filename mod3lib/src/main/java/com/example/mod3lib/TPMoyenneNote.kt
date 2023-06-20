package com.example.mod3lib



fun main() {
    /*    val scan = Scanner(System.`in`)*/
    println("entrez le nombre de valeurs")
    var nbVal = readLine()

    var nbNote:Int=0

    val tableauNote = mutableListOf<Float>()

    if (nbVal != null) {
        do {
            println("Valeur:")
            var note = readLine()
            if (note != null) {
                tableauNote.add(note.toFloat())
            }
            nbNote++

        } while (nbNote<nbVal.toInt())
    }

    var somme : Float = tableauNote.sum()
    println(somme)
    println(nbVal)


   var result : Float= (somme/ (nbVal?.toInt() ?:0 ))


    println(result)
}
