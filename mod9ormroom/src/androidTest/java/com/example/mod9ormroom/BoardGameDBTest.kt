package com.example.mod9ormroom

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mod9ormroom.bo.BoardGame
import com.example.mod9ormroom.bo.Theme
import com.example.mod9ormroom.bo.Type
import com.example.mod9ormroom.db.AppDataBase
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BoardGameDBTest {


    private lateinit var db : AppDataBase

    @Before
    fun createBdd(){
        db= Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDataBase::class.java
        ).build()

    }
    @Test
    fun testInsertBoardGame(){
        val game = BoardGame("Dixit",0,3,8, Type.CARDS, Theme.FANTASTIC)

       // val id = db.getBoardGameDAO().insert(game)

       // assertTrue("Jeu non valide !",db.getBoardGameDAO().getById(id).name==game.name)

    }

}

