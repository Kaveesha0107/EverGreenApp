package com.example.evergreenapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat

class CollectionsActivity : AppCompatActivity() {

    private data class CardInfo(
        val idName: String,
        val date: String,
        val quantity: String,
        val status: String,
        val amount: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false
        // Use whichever layout exists: activity_collections OR collection
        val layoutRes = listOf("activity_collections", "collection")
            .map { resources.getIdentifier(it, "layout", packageName) }
            .firstOrNull { it != 0 }
            ?: run {
                Log.e("CollectionsActivity", "No collections layout found. Expected activity_collections.xml or collection.xml")
                R.layout.activity_collections // fallback (will crash if missing)
            }
        setContentView(layoutRes)

        // Back button
        findViewById<ImageView?>(R.id.btn_back)?.setOnClickListener { finish() }

        // Card taps -> PaymentDetailsActivity (use runtime id lookup to bypass R.id compile complaints)
        val cards = listOf(
            CardInfo("collection_card_1", "July 29, 2025", "25 Kg", "Pending",   "LKR 2750"),
            CardInfo("collection_card_2", "July 28, 2025", "50 Kg", "Collected", "LKR 5500"),
            CardInfo("collection_card_3", "July 27, 2025", "30 Kg", "Collected", "LKR 3300"),
            CardInfo("collection_card_4", "July 26, 2025", "45 Kg", "Collected", "LKR 4950")
        )
        cards.forEach { c ->
            val viewId = resources.getIdentifier(c.idName, "id", packageName)
            if (viewId == 0) {
                Log.e("CollectionsActivity", "ID not found in inflated layout: ${c.idName}")
            } else {
                findViewById<CardView?>(viewId)?.setOnClickListener {
                    openPaymentDetails(c.date, c.quantity, c.status, c.amount)
                }
            }
        }

        // Bottom navigation (select first, then attach listener)
        val bottomNavId = resources.getIdentifier("bottom_navigation", "id", packageName)
        val bottomNav = findViewById<BottomNavigationView?>(bottomNavId)
        bottomNav?.selectedItemId = R.id.nav_collections
        bottomNav?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomeActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    })
                    finish()
                    true
                }
                R.id.nav_collections -> true
                R.id.nav_reports -> {
                    startActivity(Intent(this, ReportsActivity::class.java)); finish(); true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java)); finish(); true
                }
                else -> false
            }
        }
    }

    private fun openPaymentDetails(
        date: String,
        quantity: String,
        status: String,
        amount: String
    ) {
        Log.d("CollectionsActivity", "Open PaymentDetails: $date, $quantity, $status, $amount")
        startActivity(Intent(this, PaymentDetailsActivity::class.java).apply {
            putExtra("date", date)
            putExtra("quantity", quantity)
            putExtra("status", status)
            putExtra("amount", amount)
        })
    }
}