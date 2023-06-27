package com.example.tplancede



import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random


class LancedeViewModel : ViewModel(){


    private var nblance1 : Int = 0

    private var nblance2 : Int = 0

    private var score1:Int=0

    private var score2:Int=0

    private var lance:Int=0

    private var idImage:Int=R.drawable.ic_launcher_foreground

    var totalLance = MutableLiveData<Int>(0)


    fun getImageDrawable() {

        when(lance){
            1->idImage=R.drawable.d1
            2->idImage=R.drawable.d2
            3->idImage=R.drawable.d3
            4->idImage=R.drawable.d4
            5->idImage=R.drawable.d5
            6->idImage=R.drawable.d6
            0->idImage= R.drawable.ic_launcher_foreground

        }

    }

    fun reset(){
        lance=0
        getImageDrawable()
        score1=0
        score2=0
        nblance1=0
        nblance2=0
        totalLance.value=0

    }

    fun getIdImage():Int{
        return idImage
    }


    fun getLance():Int{
        return lance
    }

    fun setLance1():Int{
        totalLance.value=totalLance.value?.inc()
        lance= Random.nextInt(1 , 7)
        getImageDrawable()
        majScore1(lance)
        increment1()
        return lance
    }

    fun setLance2():Int{
        totalLance.value=totalLance.value?.inc()
        lance= Random.nextInt(1 , 7)
        getImageDrawable()
        majScore2(lance)
        increment2()
        return lance
    }

    fun increment1():Int{
        return ++nblance1
    }

    fun getNblance1():Int{

        return nblance1
    }

    fun increment2():Int{
        return ++nblance2
    }

    fun getNblance2():Int{

        return nblance2
    }

    fun majScore1(de : Int) : Int{
        score1+=de
        return score1
    }

    fun getScore1():Int{
        return score1
    }

    fun majScore2(de : Int) : Int{
        score2+=de
        return score2
    }

    fun getScore2():Int{
        return score2
    }

}