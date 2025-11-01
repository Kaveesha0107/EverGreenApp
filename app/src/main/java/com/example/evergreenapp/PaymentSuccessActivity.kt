package com.example.evergreenapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat

class PaymentSuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("PaymentSuccessActivity", "onCreate called")
        setContentView(R.layout.payment_success) // ensure this is the correct layout name

        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false

        val backArrow = findViewById<ImageView?>(R.id.back_arrow)
        val backToHomeButton = findViewById<MaterialButton?>(R.id.btn_back_to_home)
        val downloadReceiptButton = findViewById<MaterialButton?>(R.id.btn_download_receipt)

        // Modern back handling (ties into system back)
        onBackPressedDispatcher.addCallback(this) {
            Log.d("PaymentSuccessActivity", "System back pressed")
            finish() // naturally returns to PaymentDetails (or previous)
        }

        // Back arrow -> behave like system back
        backArrow?.setOnClickListener {
            Log.d("PaymentSuccessActivity", "Back arrow clicked")
            onBackPressedDispatcher.onBackPressed()
        }

        // Back to Home -> start fresh task at Home
        backToHomeButton?.setOnClickListener {
            Log.d("PaymentSuccessActivity", "Back to home button clicked")
            startActivity(
                Intent(this, HomeActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                }
            )

        }

        // Download receipt (stub)
        downloadReceiptButton?.setOnClickListener {
            Log.d("PaymentSuccessActivity", "Download receipt button clicked")
            Toast.makeText(this, "Downloading receipt...", Toast.LENGTH_SHORT).show()
            // TODO: generate/download the PDF here
        }
    }
}