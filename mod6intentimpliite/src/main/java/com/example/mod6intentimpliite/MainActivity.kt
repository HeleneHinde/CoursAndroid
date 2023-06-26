package com.example.mod6intentimpliite


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
//préparation de la demande d'autorisation
    val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()

    ) {isGranted->
        //si l'utilisateur autorise l'application alors je lance l'appel
        if (isGranted){
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:0606060606"))
            startActivity(intent)
        } else {
            //sinon, je compose le numéro sur l'application d'appel, sans lancé l'appel
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:0606060606"))
            startActivity(intent)

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val buttonMap = findViewById<Button>(R.id.buttonMap)

        buttonMap.setOnClickListener {

            //quand on clic sur le bouton, on arrive sur une page web ouverte avec le navigateur du téléphone

/*            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.fr")).also {
            startActivity(it)
            }*/

            //quand on clic sur le bouton on arrive sur google map aux coordonnées du point gps indiqué
            Intent(Intent.ACTION_VIEW,Uri.parse("geo:48.04,-1.69")).also {

                startActivity(it)

            }

        }

        button.setOnClickListener {
            requestPermissionLauncher.launch(android.Manifest.permission.CALL_PHONE)


        }

    }
}