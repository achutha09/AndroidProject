package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val explicitlyButton: Button = findViewById(R.id.startExplicitlyButton)
        val implicitlyButton: Button = findViewById(R.id.startImplicitlyButton)

        // Set click listener for "Start Activity Explicitly" button
        explicitlyButton.setOnClickListener {
            val explicitIntent = Intent(this, SecondActivity::class.java)
            startActivity(explicitIntent)
        }

        // Set click listener for "Start Activity Implicitly" button
        implicitlyButton.setOnClickListener {
            val implicitIntent = Intent("com.example.assignmentapp.START_SECOND_ACTIVITY")
            startActivity(implicitIntent)
        }
    }
}
