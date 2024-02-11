package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val textViewChallenges = findViewById<TextView>(R.id.textViewChallenges)
        textViewChallenges.text = getString(R.string.mobile_software_engineering_challenges_list)
    }
}
