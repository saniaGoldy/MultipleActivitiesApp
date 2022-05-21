package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        this.title = "Activity 2"

        val forwardButton = findViewById<Button>(R.id.navigation_next_button_activity2)
        val goBackButton = findViewById<Button>(R.id.navigation_prev_button_activity2)

        forwardButton.setOnClickListener {
            startActivity(Intent(this, Activity3::class.java))
        }
        goBackButton.setOnClickListener{
            startActivity(Intent(this, Activity1::class.java))
        }
    }
}