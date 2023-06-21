package com.example.tprandom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)

        var min = findViewById<EditText>(R.id.et_minimum)
        var max = findViewById<EditText>(R.id.et_maximum)

        var result = findViewById<TextView>(R.id.et_result2)


        btn.setOnClickListener {
            var mini = min.text?.toString()?.toIntOrNull()
            var maxi = max.text?.toString()?.toIntOrNull()
            var rand: Int? = null

            if (mini != null) {
                if (maxi != null) {
                    if (mini < maxi) {
                        rand = Random.nextInt(mini, maxi.plus(1))
                        result.text = rand.toString()

                    } else {
                        Toast.makeText(
                            this,
                            "Le minimum doit être inférieur au maximum",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    rand = Random.nextInt(mini, 1000000)
                    result.text = rand.toString()
                }
            } else {
                Toast.makeText(
                    this,
                    "Veuillez au moins rentrer un nombre minimum",
                    Toast.LENGTH_LONG
                ).show()
            }






        }

    }
}