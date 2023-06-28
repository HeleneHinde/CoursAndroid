package com.example.tpqualiteair

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tpqualiteair.bo.Ville
import com.example.tpqualiteair.db.AppDataBase
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class VilleDBTest {

    private lateinit var db : AppDataBase


    @Before
    fun createBdd(){
        db= Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),AppDataBase::class.java
        ).build()

    }

    @Test
    fun testInsertBoardGame(){
        val ville = Ville(0, "Orgères", 3.5F)

      //  val id = db.getVilleDAO().insert(ville)

        //assertTrue("C'est pas ok !", db.getVilleDAO().getById(id).nom==ville.nom)

    }

}