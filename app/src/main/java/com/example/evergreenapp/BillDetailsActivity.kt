package com.example.evergreenapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat

class BillDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("BillDetailsActivity", "onCreate called")
        setContentView(R.layout.activity_bill_details)

        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false

        // Back button (works whether it's ImageView or ImageButton)
        findViewById<View?>(R.id.btn_back)?.setOnClickListener {
            Log.d("BillDetailsActivity", "Back button clicked")
            finish()
        }

        // Accept & Confirm -> PaymentDetailsActivity
        findViewById<Button?>(R.id.btn_accept_confirm)?.setOnClickListener {
            Log.d("BillDetailsActivity", "Accept & Confirm button clicked")
            startActivity(Intent(this, PaymentDetailsActivity::class.java))
        }

        // Bottom navigation (if present on this screen)
        val bottomNav = findViewById<BottomNavigationView?>(R.id.bottom_navigation) ?: return

        // 1) Mark current tab FIRST so it doesn’t trigger navigation away
        //    If BillDetails belongs under a different tab, change nav_reports accordingly.
        bottomNav.selectedItemId = R.id.nav_reports

        // 2) THEN attach the listener
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(
                        Intent(this, HomeActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                        }
                    )
                    finish()
                    true
                }
                R.id.nav_collections -> {
                    startActivity(Intent(this, CollectionsActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_reports -> true // already on a Reports-related screen
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}