package com.example.ygeia

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Workout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.workout)

        // Connect your Smart Watch for real-time data
        val smartWatchText: TextView = findViewById(R.id.smart_watch_7)
        val textSmartWatch = "Connect your Smart Watch\nfor real-time data"
        val spannableSmartWatch = SpannableString(textSmartWatch)

        // Connect your Smart Watch
        spannableSmartWatch.setSpan(ForegroundColorSpan(Color.parseColor("#81DE75")), 0, 25, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        // for real-time data
        spannableSmartWatch.setSpan(ForegroundColorSpan(Color.parseColor("#80FFFFFF")), 25, textSmartWatch.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        smartWatchText.text = spannableSmartWatch

        // Nav-Bar buttons
        val homePageButton: ImageView = findViewById(R.id.home_page_icon_7)

        homePageButton.setOnClickListener {
            val navigateToHomePage = Intent(this@Workout, HomePage::class.java)
            startActivity(navigateToHomePage)
        }

        val challengesButton: ImageView = findViewById(R.id.challenges_icon_7)

        challengesButton.setOnClickListener {
            val navigateToHomePage = Intent(this@Workout, Challenges::class.java)
            startActivity(navigateToHomePage)
        }

        val bmiCalculatorButton: ImageView = findViewById(R.id.bmi_calculator_icon_7)

        bmiCalculatorButton.setOnClickListener {
            val navigateToBMICalculator = Intent(this@Workout, BMICalculator::class.java)
            startActivity(navigateToBMICalculator)
        }

        val moreOptionsButton: ImageView = findViewById(R.id.more_options_icon_7)

        moreOptionsButton.setOnClickListener {
            val navigateToMoreOptions = Intent(this@Workout, MoreOptions::class.java)
            startActivity(navigateToMoreOptions)
        }
    }
}
