package com.example.evergreenapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {

    // Define a constant for the splash screen delay in milliseconds (2 seconds)
    private val SPLASH_DELAY: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true


        Handler(Looper.getMainLooper()).postDelayed({
            // Create an Intent to start the OnboardingActivity
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)

            // Finish the current activity so the user cannot navigate back to the splash screen
            finish()
        }, SPLASH_DELAY)
    }
}
