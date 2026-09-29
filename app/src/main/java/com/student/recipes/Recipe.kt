package com.student.recipes

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("name") val name: String,
    @SerializedName("cuisine") val cuisine: String
)
