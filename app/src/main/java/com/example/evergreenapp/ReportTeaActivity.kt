package com.example.evergreenapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat

class ReportTeaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ReportTeaActivity", "onCreate called")
        setContentView(R.layout.activity_report_tea)

        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false

        val backButton: ImageView? = findViewById(R.id.iv_back_button)
        val submitButton: Button? = findViewById(R.id.btn_submit)
        val bottomNavigationView: BottomNavigationView? = findViewById(R.id.bottom_navigation)

        // Back button with null safety
        backButton?.setOnClickListener {
            Log.d("ReportTeaActivity", "Back button clicked")
            finish()
        }


        submitButton?.setOnClickListener {
            Log.d("ReportTeaActivity", "Submit button clicked")

            try {
                val intent = Intent(this, BillDetailsActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Tea collection reported successfully!", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Log.e("ReportTeaActivity", "Error: ${e.message}")
                Toast.makeText(this, "Error occurred. Please try again.", Toast.LENGTH_SHORT).show()
            }
        }


        bottomNavigationView?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomeActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                    })
                    finish()
                    true
                }
                R.id.nav_collections -> {
                    startActivity(Intent(this, CollectionsActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_reports -> true
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }

        bottomNavigationView?.selectedItemId = R.id.nav_reports
    }
}