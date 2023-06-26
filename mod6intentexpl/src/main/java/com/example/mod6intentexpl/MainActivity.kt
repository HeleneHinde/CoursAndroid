package com.example.mod6intentexpl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mod6intentexpl.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
/*            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)*/

            //autre écriture avec le .also
            Intent(this, LoginActivity::class.java).also {
                startActivity(it)
            }
        }


    }
}