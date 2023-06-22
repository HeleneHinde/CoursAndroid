package com.example.tphistoire

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Histoire(val prenom : String, var lieu : String) : Parcelable
