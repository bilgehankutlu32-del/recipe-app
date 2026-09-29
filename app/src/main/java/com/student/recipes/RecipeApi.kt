package com.student.recipes

import retrofit2.Call
import retrofit2.http.GET

interface RecipeApi {
    @GET("database.json")
    fun getRecipes(): Call<List<Recipe>>
}
