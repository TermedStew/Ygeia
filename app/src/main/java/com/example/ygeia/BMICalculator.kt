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

class BMICalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.bmi_calculator)

        val bmiText: TextView = findViewById(R.id.bmi_calculator)
        val textBMI = "BMI Calculator"
        val spannableBMI = SpannableString(textBMI)

        spannableBMI.setSpan(ForegroundColorSpan(Color.parseColor("#81DE75")), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        bmiText.text = spannableBMI

        // NavBar buttons
        val homePageButton: ImageView = findViewById(R.id.home_page_icon_6)

        homePageButton.setOnClickListener {
            val navigateToHomePage = Intent(this@BMICalculator, HomePage::class.java)
            startActivity(navigateToHomePage)
        }

        val challengesButton: ImageView = findViewById(R.id.challenges_icon_6)

        challengesButton.setOnClickListener {
            val navigateToHomePage = Intent(this@BMICalculator, Challenges::class.java)
            startActivity(navigateToHomePage)
        }

        val workoutButton: ImageView = findViewById(R.id.workout_icon_6)

        workoutButton.setOnClickListener {
            val navigateToWorkout = Intent(this@BMICalculator, Workout::class.java)
            startActivity(navigateToWorkout)
        }

        val moreOptionsButton: ImageView = findViewById(R.id.more_options_icon_6)

        moreOptionsButton.setOnClickListener {
            val navigateToMoreOptions = Intent(this@BMICalculator, MoreOptions::class.java)
            startActivity(navigateToMoreOptions)
        }
    }
}
