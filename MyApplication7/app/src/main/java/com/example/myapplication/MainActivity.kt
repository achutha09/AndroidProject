package com.example.myapplication

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val CAMERA_PERMISSION_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val explicitlyButton: Button = findViewById(R.id.startExplicitlyButton)
        val implicitlyButton: Button = findViewById(R.id.startImplicitlyButton)// Ensure this ID is correct
        val viewImageActivityButton: Button = findViewById(R.id.viewImageActivityButton)

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

        // Set click listener for "View Image Activity" button
        viewImageActivityButton.setOnClickListener {
            // Check camera permission before starting the activity to capture image
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                // Request the permission
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_REQUEST_CODE
                )
            } else {
                // Permission already granted, start com.example.myapplication.ThirdActivity to capture image
                startActivity(Intent(this, ThirdActivity::class.java))
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Camera permission granted, start com.example.myapplication.ThirdActivity to capture image
                startActivity(Intent(this, ThirdActivity::class.java))
            } else {
                // Camera permission denied, show a toast or take appropriate action
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
