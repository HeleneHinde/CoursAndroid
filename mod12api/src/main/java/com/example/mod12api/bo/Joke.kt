package com.example.mod12api.bo

import com.squareup.moshi.Json

data class Joke(val id:Int,
                @Json(name="joke")
                val content : String,
                val ratingScore : String?)


