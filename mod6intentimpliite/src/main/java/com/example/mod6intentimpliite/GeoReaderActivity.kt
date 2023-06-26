package com.example.mod6intentimpliite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

private const val TAG = "GeoReaderActivity"
class GeoReaderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geo_reader)

        Log.i(TAG, "onCreate: "+ intent.data.toString())


    }
}