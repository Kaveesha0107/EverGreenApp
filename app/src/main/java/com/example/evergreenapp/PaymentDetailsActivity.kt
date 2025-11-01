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

class PaymentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("PaymentDetailsActivity", "onCreate called")
        setContentView(R.layout.activity_payment_details)

        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false

        // Back button (works for ImageView or ImageButton)
        findViewById<View?>(R.id.btn_back)?.setOnClickListener {
            Log.d("PaymentDetailsActivity", "Back button clicked")
            finish()
        }

        // Confirm payment -> PaymentSuccessActivity
        findViewById<Button?>(R.id.btn_confirm_payment)?.setOnClickListener {
            Log.d("PaymentDetailsActivity", "Confirm payment button clicked")
            startActivity(Intent(this, PaymentSuccessActivity::class.java))
        }


        val bottomNav = findViewById<BottomNavigationView?>(R.id.bottom_navigation) ?: return


        bottomNav.selectedItemId = R.id.nav_reports


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
                R.id.nav_reports -> true // already on a Reports-related flow
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