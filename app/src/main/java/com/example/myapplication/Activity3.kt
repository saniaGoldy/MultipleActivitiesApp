package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3)
        this.title = "Activity 3"

        val forwardButton = findViewById<Button>(R.id.navigation_next_button_activity3)
        val goBackButton = findViewById<Button>(R.id.navigation_prev_button_activity3)

        forwardButton.setOnClickListener {
            startActivity(Intent(this, Activity4::class.java))
        }
        goBackButton.setOnClickListener{
            startActivity(Intent(this, Activity2::class.java))
        }
    }
}