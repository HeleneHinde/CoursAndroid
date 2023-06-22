package com.example.mod5navinterne

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val firstname:String, val lastname:String) : Parcelable
