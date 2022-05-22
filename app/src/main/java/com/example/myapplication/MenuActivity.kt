package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val firstPartButton = findViewById<Button>(R.id.FirstPartButton)
        val secondPartButton = findViewById<Button>(R.id.SecondPartButton)

        firstPartButton.setOnClickListener{
            startActivity(Intent(this, Activity1::class.java))
        }
        secondPartButton.setOnClickListener{
            startActivity(Intent(this, ServiceActivity::class.java))
        }
    }
}