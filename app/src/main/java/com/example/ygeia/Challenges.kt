package com.example.ygeia

import android.app.appsearch.PropertyPath
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Challenges : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.challenges)

        val dailyChallText: TextView = findViewById(R.id.daily_challenges)
        val textDailyChall = "Daily Challenges"
        val spannableChall = SpannableString(textDailyChall)

        spannableChall.setSpan(ForegroundColorSpan(Color.parseColor("#81DE75")), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        dailyChallText.text = spannableChall

        val weeklyChallText: TextView = findViewById(R.id.weekly_challenges)
        val textWeeklyChall = "Weekly Challenges"
        val spannableWeekly = SpannableString(textWeeklyChall)

        spannableWeekly.setSpan(ForegroundColorSpan(Color.parseColor("#81DE75")), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        weeklyChallText.text = spannableWeekly

        val challArenaText: TextView = findViewById(R.id.challenge_arena)
        val textChallArena = "Challenge Arena"
        val spannableChallArena = SpannableString(textChallArena)

        spannableChallArena.setSpan(ForegroundColorSpan(Color.parseColor("#81DE75")), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        challArenaText.text = spannableChallArena

        val teamChallText: TextView = findViewById(R.id.team_challenge)
        val textTeamChall = "Team Challenge"
        val spannableTeamChall = SpannableString(textTeamChall)

        spannableTeamChall.setSpan(ForegroundColorSpan(Color.parseColor("#8CD9FF")), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        teamChallText.text = spannableTeamChall

        val currentXP = intent.getIntExtra("current_xp", 0)
        val maxXP = intent.getIntExtra("max_xp", 20)
        val level = intent.getIntExtra("LEVEL", 1)

        val progressBar = findViewById<ProgressBar>(R.id.progress_bar_xp_5)
        val progressText = findViewById<TextView>(R.id.progress_bar_xp_text_5)
        val xpLeftText = findViewById<TextView>(R.id.xp_left_5)
        val levelText = findViewById<TextView>(R.id.current_lvl_5)
        // coins = findViewById(R.id.coins_5)

        progressBar.max = maxXP
        progressBar.progress = currentXP

        progressText.text = "$currentXP/$maxXP"
        levelText.text = "Level $level"

        val xpToNextLevel = maxXP - currentXP
        xpLeftText.text = "$xpToNextLevel more XP to Lvl. ${level + 1}"

        // Home Page button
        val homePageButton: ImageView = findViewById(R.id.home_page_icon_5)

        homePageButton.setOnClickListener {
            val navigateToHomePage = Intent(this@Challenges, HomePage::class.java)
            startActivity(navigateToHomePage)
        }

        val bmiCalculatorButton: ImageView = findViewById(R.id.bmi_calculator_icon_5)

        bmiCalculatorButton.setOnClickListener {
            val navigateToBMICalculator = Intent(this@Challenges, BMICalculator::class.java)
            startActivity(navigateToBMICalculator)
        }

        val workoutButton: ImageView = findViewById(R.id.workout_icon_5)

        workoutButton.setOnClickListener {
            val navigateToWorkout = Intent(this@Challenges, Workout::class.java)
            startActivity(navigateToWorkout)
        }

        val moreOptionsButton: ImageView = findViewById(R.id.more_options_icon_5)

        moreOptionsButton.setOnClickListener {
            val navigateToMoreOptions = Intent(this@Challenges, MoreOptions::class.java)
            startActivity(navigateToMoreOptions)
        }
    }
}
