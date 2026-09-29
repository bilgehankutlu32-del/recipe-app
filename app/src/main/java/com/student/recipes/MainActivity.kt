package com.student.recipes

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        adapter = RecipeAdapter(emptyList())
        recyclerView.adapter = adapter

        fetchRecipes()
    }

    private fun fetchRecipes() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/bilgehankutlu32-del/GMS-3039-/refs/heads/main/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(RecipeApi::class.java)

        api.getRecipes().enqueue(object : Callback<List<Recipe>> {
            override fun onResponse(call: Call<List<Recipe>>, response: Response<List<Recipe>>) {
                if (response.isSuccessful && response.body() != null) {
                    adapter.updateData(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<Recipe>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Veri cekilemedi: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}
