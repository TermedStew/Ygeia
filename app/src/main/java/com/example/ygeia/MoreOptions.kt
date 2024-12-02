package com.example.ygeia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MoreOptions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.more_options)

        // Nav-Bar buttons
        val homePageButton: ImageView = findViewById(R.id.home_page_icon_8)

        homePageButton.setOnClickListener {
            val navigateToHomePage = Intent(this@MoreOptions, HomePage::class.java)
            startActivity(navigateToHomePage)
        }

        val challengesButton: ImageView = findViewById(R.id.challenges_icon_8)

        challengesButton.setOnClickListener {
            val navigateToHomePage = Intent(this@MoreOptions, Challenges::class.java)
            startActivity(navigateToHomePage)
        }

        val bmiCalculatorButton: ImageView = findViewById(R.id.bmi_calculator_icon_8)

        bmiCalculatorButton.setOnClickListener {
            val navigateToBMICalculator = Intent(this@MoreOptions, BMICalculator::class.java)
            startActivity(navigateToBMICalculator)
        }

        val workoutButton: ImageView = findViewById(R.id.workout_icon_8)

        workoutButton.setOnClickListener {
            val navigateToWorkout = Intent(this@MoreOptions, Workout::class.java)
            startActivity(navigateToWorkout)
        }

        // Other buttons (Temporary comment)
        val logoutButton: Button = findViewById(R.id.logout_button_8)

        logoutButton.setOnClickListener {
            val navigateToWelcomePage = Intent(this@MoreOptions, WelcomePage::class.java)
            startActivity(navigateToWelcomePage)
        }
    }
}
