package com.example.evergreenapp

import android.content.Intent
import android.os.Bundle
import android.view.View // Import View to access findViewById
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat

// This class manages the login screen and navigates to other activities.
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enable edge-to-edge display for a modern, full-screen experience.
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the views by their IDs.
        val loginButton = findViewById<Button>(R.id.btn_login)
        val signUpLink = findViewById<TextView>(R.id.tv_sign_up)
        val forgotPasswordLink = findViewById<TextView>(R.id.tv_forgot_password)


        loginButton.setOnClickListener {
            val username = findViewById<android.widget.EditText>(R.id.et_username).text.toString()
            val password = findViewById<android.widget.EditText>(R.id.et_password).text.toString()

            // Basic input validation
            if (username.isEmpty() || password.isEmpty()) {
                android.widget.Toast.makeText(this, "Please fill in all fields", android.widget.Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Show loading state
            loginButton.isEnabled = false
            loginButton.text = "Logging in..."


            android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                // Finish the current activity so the user can't press back to return to the login screen.
                finish()
            }, 1500) // 1.5 second delay to simulate authentication
        }


        signUpLink.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }



        forgotPasswordLink.setOnClickListener {
            android.widget.Toast.makeText(this, "Forgot password functionality coming soon!", android.widget.Toast.LENGTH_SHORT).show()
        }
    }
}
