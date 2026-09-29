package com.student.recipes

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashImage = findViewById<ImageView>(R.id.splashImageView)
        val handler = Handler(Looper.getMainLooper())

        // 1. saniye: Asya yemeğine geç
        handler.postDelayed({
            splashImage.setImageResource(R.drawable.yemek_asya)
        }, 1000)

        // 2. saniye: Avrupa yemeğine geç
        handler.postDelayed({
            splashImage.setImageResource(R.drawable.yemek_avrupa)
        }, 2000)

        // 3. saniye: Ana menüye (MainActivity) geç ve bu ekranı kapat
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
