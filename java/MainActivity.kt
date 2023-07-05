package com.merqurex.test1

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set your custom color
        val lightPurple = Color.parseColor("#F7F0FD") // Replace with your desired color value
        // Set the UI visibility flags
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        }
        // Set the status bar and navigation bar color
        window.statusBarColor = lightPurple
        window.navigationBarColor = lightPurple
        setContentView(R.layout.activity_main)

        val emailLoginLayout = findViewById<TextInputLayout>(R.id.email_login_layout)
        val emailLoginEditText = findViewById<TextInputEditText>(R.id.email_login_edittext)

        val passwordLoginLayout = findViewById<TextInputLayout>(R.id.password_login_layout)
        val passwordLoginEditText = findViewById<TextInputEditText>(R.id.password_login_edittext)

        val loginButton = findViewById<Button>(R.id.login_button)
        val createAccountIntent = findViewById<Button>(R.id.createacc_intent_button)

        loginButton.setOnClickListener {
            val email = emailLoginEditText.text.toString().trim()
            val password = passwordLoginEditText.text.toString()

            var isValid = true

            if (email.isEmpty() || !isEmailValid(email)) {
                emailLoginLayout.error = "Please enter a valid email address"
                isValid = false
            } else {
                emailLoginLayout.error = null
            }

            if (password.isEmpty() || !isPasswordValid(password)) {
                passwordLoginLayout.error = "Please enter a valid password"
                isValid = false
            } else {
                passwordLoginLayout.error = null
            }

            if (isValid) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                // Create blank intent for testing purposes
                val blankIntent = Intent(this, BlankActivity::class.java)
                startActivity(blankIntent)
            } else {
//                Toast.makeText(this, "Invalid input, please check your details", Toast.LENGTH_SHORT).show()
            }
        }

        createAccountIntent.setOnClickListener {
            val createAccountIntent = Intent(this, SignUpActivity::class.java)
            startActivity(createAccountIntent)
        }
    }

    private fun isEmailValid(email: String): Boolean {
        // Validate email criteria using Patterns.EMAIL_ADDRESS matcher
        val emailPattern = Patterns.EMAIL_ADDRESS
        return emailPattern.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean {
        // Validate password criteria (at least 6 characters long)
        return password.length >= 6
    }
}
