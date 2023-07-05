package com.merqurex.test1

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class BlankActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_blank)
    }
}