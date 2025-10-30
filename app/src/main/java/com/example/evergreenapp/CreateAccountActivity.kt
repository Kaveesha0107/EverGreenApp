package com.example.evergreenapp

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.evergreenapp.R



class CreateAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_create_account)

        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val backArrow: ImageView = findViewById(R.id.back_arrow)
        val signUpLink: TextView = findViewById(R.id.tv_login_link)
        val createAccountButton: Button = findViewById(R.id.btn_create_account)


        val fullNameField = findViewById<android.widget.EditText>(R.id.et_full_name)
        val phoneNumberField = findViewById<android.widget.EditText>(R.id.et_phone_number)
        val locationField = findViewById<android.widget.EditText>(R.id.et_location)
        val passwordField = findViewById<android.widget.EditText>(R.id.et_password)
        val confirmPasswordField = findViewById<android.widget.EditText>(R.id.et_confirm_password)


        backArrow.setOnClickListener {
            finish()
        }


        signUpLink.setOnClickListener {
            finish()
        }


        createAccountButton.setOnClickListener {
            val fullName = fullNameField.text.toString()
            val phoneNumber = phoneNumberField.text.toString()
            val location = locationField.text.toString()
            val password = passwordField.text.toString()
            val confirmPassword = confirmPasswordField.text.toString()

            // Basic input validation
            if (fullName.isEmpty() || phoneNumber.isEmpty() || location.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                android.widget.Toast.makeText(this, "Please fill in all fields", android.widget.Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                android.widget.Toast.makeText(this, "Passwords do not match", android.widget.Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.length < 6) {
                android.widget.Toast.makeText(this, "Password must be at least 6 characters", android.widget.Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validate phone number (basic check for length)
            if (phoneNumber.length < 10) {
                android.widget.Toast.makeText(this, "Please enter a valid phone number", android.widget.Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validate location (should not be too short)
            if (location.length < 3) {
                android.widget.Toast.makeText(this, "Please enter a valid location", android.widget.Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Show loading state
            createAccountButton.isEnabled = false
            createAccountButton.text = "Creating Account..."



            android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                android.widget.Toast.makeText(this, "Account created successfully!", android.widget.Toast.LENGTH_SHORT).show()
                finish()
            }, 2000) // 2 second delay to simulate account creation
        }
    }
}
