package com.example.evergreenapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("HomeActivity", "onCreate called")
        setContentView(R.layout.activity_home)


        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false
        // Views
        val reportCollectionButton: Button = findViewById(R.id.btn_report_tea)
        val viewHistoryButton: Button = findViewById(R.id.btn_view_history)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val profileIcon: ImageView = findViewById(R.id.iv_profile)

        // Report Tea → ReportTeaActivity
        reportCollectionButton.setOnClickListener {
            Log.d("HomeActivity", "Report Tea button clicked")
            startActivity(Intent(this, ReportTeaActivity::class.java))
        }

        // View History → CollectionsActivity
        viewHistoryButton.setOnClickListener {
            Log.d("HomeActivity", "View History button clicked")
            startActivity(Intent(this, CollectionsActivity::class.java))
        }

        // Profile icon
        profileIcon.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        // Bottom Navigation
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_collections -> {
                    startActivity(Intent(this, CollectionsActivity::class.java))
                    true
                }
                R.id.nav_reports -> {
                    startActivity(Intent(this, ReportsActivity::class.java))
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                else -> false
            }
        }

        bottomNavigationView.selectedItemId = R.id.nav_home
    }

    override fun onBackPressed() {
        android.app.AlertDialog.Builder(this)
            .setTitle("Exit App")
            .setMessage("Are you sure you want to exit?")
            .setPositiveButton("Yes") { _, _ -> super.onBackPressed() }
            .setNegativeButton("No", null)
            .show()
    }
}
