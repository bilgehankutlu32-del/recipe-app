package com.student.recipes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val myRecipes = listOf(
            Recipe("Tirmis Hardalı", "Antalya / Özel Reçete"),
            Recipe("Karamelize Soya-Ballı Karides & Arancini", "Asya Füzyon / Fine Dining"),
            Recipe("Hünkarbeğendi", "Osmanlı / Klasik"),
            Recipe("Taze Trüflü Ev Yapımı Makarna", "Pollenzo, İtalya / Yöresel"),
            Recipe("Tütsülenmiş Dana Brisket", "Teksas, Amerika / BBQ")
        )

        val adapter = RecipeAdapter(myRecipes)
        recyclerView.adapter = adapter
    }
}
