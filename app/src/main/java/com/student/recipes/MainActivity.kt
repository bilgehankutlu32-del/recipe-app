package com.student.recipes

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val textView = TextView(this)
        textView.text = "Pollenzo Recipe Database is Loading..."
        textView.textSize = 20f
        setContentView(textView)
    }
}