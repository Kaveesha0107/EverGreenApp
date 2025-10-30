package com.example.evergreenapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ProfileActivity", "onCreate called")
        setContentView(R.layout.activity_profile)

        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false

        // Find views
        val logoutButton: Button = findViewById(R.id.btn_logout_bottom)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Logout button click listener
        logoutButton.setOnClickListener {
            Log.d("ProfileActivity", "Logout button clicked")
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Bottom navigation
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.nav_collections -> {
                    val intent = Intent(this, CollectionsActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.nav_reports -> {
                    val intent = Intent(this, ReportsActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.nav_profile -> {
                    true
                }
                else -> false
            }
        }

        bottomNavigationView.selectedItemId = R.id.nav_profile
    }
}
