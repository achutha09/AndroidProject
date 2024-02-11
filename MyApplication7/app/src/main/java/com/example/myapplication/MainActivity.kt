package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startExplicitlyButton: Button = findViewById(R.id.startExplicitlyButton)
        val startImplicitlyButton: Button = findViewById(R.id.startImplicitlyButton)

        // Set click listener for "Start Activity Explicitly" button
        startExplicitlyButton.setOnClickListener {
            val explicitIntent = Intent(this, SecondActivity::class.java)
            startActivity(explicitIntent)
        }

        // Set click listener for "Start Activity Implicitly" button
        startImplicitlyButton.setOnClickListener {
            val implicitIntent = Intent("com.example.assignmentapp.START_SECOND_ACTIVITY")
            startActivity(implicitIntent)
        }
    }
}
