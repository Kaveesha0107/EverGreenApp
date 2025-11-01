package com.example.evergreenapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat

class ReportsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ReportsActivity", "onCreate called")
        setContentView(R.layout.activity_reports)

        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false

        // Find views
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val exportReportButton: MaterialButton = findViewById(R.id.btn_export_report)

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
                    true
                }
                R.id.nav_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                else -> false
            }
        }

        // Export report button click listener
        exportReportButton.setOnClickListener {
            Log.d("ReportsActivity", "Export report button clicked")
            Toast.makeText(this, "Exporting report...", Toast.LENGTH_SHORT).show()
        }

        bottomNavigationView.selectedItemId = R.id.nav_reports
    }
}
