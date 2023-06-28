package com.example.mod10recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mod10recycleview.adapter.CatAdapter
import com.example.mod10recycleview.bo.Cat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listCat = arrayListOf<Cat>(
            Cat("Loot", "Noir", "Jaune", 8),
            Cat("Pikachu", "Marron et blanc", "Marron", 14),
            Cat("Simba", "Gris", "jaune",12),
            Cat("Rosalie","Tricolore","Bleu",16),
            Cat("César", "Blanc", "Jaune", 5)
        )

        val recycler = findViewById<RecyclerView>(R.id.recycler)

        recycler.adapter = CatAdapter(listCat){
            Toast.makeText(this,it.name, Toast.LENGTH_LONG).show()
        }
        recycler.layoutManager = LinearLayoutManager(this)
    }
}