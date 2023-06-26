package com.example.tpnemoubliepas

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.example.tpnemoubliepas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"
    var tel: String? = null
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()

        ) { isGranted ->
            //si l'utilisateur autorise l'application alors j'envoi un sms
            if (isGranted) {

                 val intent = Intent(Intent.ACTION_SENDTO, Uri.parse(tel))
                Log.i(TAG, "onCreate: "+tel)
                intent.putExtra("sms_body", "Coucou");
                startActivity(intent)

/*                val message = "Coucou"

                try {
                    val smsManager = SmsManager.getDefault()
                    smsManager.sendTextMessage(tel, null, message, null, null)
                    Log.i(TAG, "SMS sent to $tel: $message")
                    Toast.makeText(this, "SMS envoyé", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Log.e(TAG, "Erreur lors de l'envoi du SMS: ${e.message}")
                    Toast.makeText(this, "Erreur lors de l'envoi du SMS", Toast.LENGTH_SHORT).show()
                }*/

            } else {
                Toast.makeText(this, "Vous devez autoriser l'application", Toast.LENGTH_LONG).show()


            }

        }

        binding.button.setOnClickListener {
            tel = "smsto:" + binding.editTextPhone.text.toString()
            requestPermissionLauncher.launch(android.Manifest.permission.SEND_SMS)


        }


    }
}