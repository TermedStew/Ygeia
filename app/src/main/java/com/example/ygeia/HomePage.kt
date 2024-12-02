package com.example.ygeia

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class HomePage : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var progressText: TextView
    private lateinit var xpLeftText: TextView
    private lateinit var levelText: TextView
    private lateinit var coins: ImageView
    private lateinit var challengesButton: ImageView

    private var currentXP = 0
    private var maxXP = 20
    private var level = 1
    private var lastXP = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_page)

        // Hello, User!
//        val welcomeText: TextView = findViewById(R.id.hello_user_4)
//        val textWelcome = "Hello, User!" // Welcome Page (refer to Figma) Sign Up text to be edited here
//        val spannableWelcome = SpannableString(textWelcome)
//
//        // Change colors of specific words using spannable
//        spannableWelcome.setSpan(ForegroundColorSpan(Color.parseColor("#81DE75")), 7, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//        welcomeText.text = spannableWelcome

//        // Steps Leaderboard (Friends)
//        val boardsText: TextView = findViewById(R.id.steps_boards_4)
//        val textBoards = "Steps Leaderboard (Friends)"
//        val spannableBoards = SpannableString(textBoards)
//
//        // Steps
//        spannableBoards.setSpan(ForegroundColorSpan(Color.parseColor("#81DE75")), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//
//        // (Friends)
//        spannableBoards.setSpan(ForegroundColorSpan(Color.parseColor("#81DE75")), 18, textBoards.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//        boardsText.text = spannableBoards

        // Challenges for Today
//        val challText: TextView = findViewById(R.id.chall_today_4)
//        val textChall = "Challenges for Today"
//        val spannableChall = SpannableString(textChall)
//
//        spannableChall.setSpan(ForegroundColorSpan(Color.parseColor("#81DE75")), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//        challText.text = spannableChall

        // Today's Stats
        val statsText: TextView = findViewById(R.id.today_stats_4)
        val textStats = "Today's Stats"
        val spannableStats = SpannableString(textStats)

        spannableStats.setSpan(ForegroundColorSpan(Color.parseColor("#81DE75")), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        statsText.text = spannableStats

        // Position
        val posText: TextView = findViewById(R.id.pos_dummy_4)
        val textPos = "1st\n2nd\n3rd"
        val spannablePos = SpannableString(textPos)

        // 1st
        spannablePos.setSpan(ForegroundColorSpan(Color.parseColor("#FFEA00")), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        // 2nd
        spannablePos.setSpan(ForegroundColorSpan(Color.parseColor("#A0A0A0")), 4, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        // 3rd
        spannablePos.setSpan(ForegroundColorSpan(Color.parseColor("#AA572D")), 8, textPos.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        posText.text = spannablePos

        // Steps Made
        val stepsText: TextView = findViewById(R.id.steps_made_4)
        val textSteps = "Steps Made"
        val spannableSteps = SpannableString(textSteps)

        spannableSteps.setSpan(ForegroundColorSpan(Color.parseColor("#8CD9FF")), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        stepsText.text = spannableSteps

        // Calories Burned
        val calText: TextView = findViewById(R.id.cal_burned_4)
        val textCal = "Calories Burned"
        val spannableCal = SpannableString(textCal)

        spannableCal.setSpan(ForegroundColorSpan(Color.parseColor("#8CD9FF")), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        calText.text = spannableCal

        // Heart Rate
        val heartText: TextView = findViewById(R.id.heart_rate_4)
        val textHeart= "Heart Rate"
        val spannableHeart = SpannableString(textHeart)

        spannableHeart.setSpan(ForegroundColorSpan(Color.parseColor("#8CD9FF")), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        heartText.text = spannableHeart

        // Challenge task 1
        val task1Text: TextView = findViewById(R.id.chall_task1_text)
        val textTask1 = "Reach 10 000 steps"
        val spannableTask1 = SpannableString(textTask1)

        spannableTask1.setSpan(ForegroundColorSpan(Color.parseColor("#8CD9FF")), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        task1Text.text = spannableTask1

        // Challenge task 2
        val task2Text: TextView = findViewById(R.id.chall_task2_text)
        val textTask2 = "Burn 500 calories"
        val spannableTask2 = SpannableString(textTask2)

        spannableTask2.setSpan(ForegroundColorSpan(Color.parseColor("#8CD9FF")), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        task2Text.text = spannableTask2

        //Challenge task 3
        val task3Text: TextView = findViewById(R.id.chall_task3_text)
        val textTask3 = "Finish at least 1 Daily Challenge"
        val spannableTask3 = SpannableString(textTask3)

        spannableTask3.setSpan(ForegroundColorSpan(Color.parseColor("#8CD9FF")), 18, 23, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        task3Text.text = spannableTask3

        // Progress Bar
        progressBar = findViewById(R.id.progress_bar_xp_4)
        progressText = findViewById(R.id.progress_bar_xp_text_4)
        xpLeftText = findViewById(R.id.xp_left_4)
        levelText = findViewById(R.id.current_lvl_4)
        coins = findViewById(R.id.coins_4)
        challengesButton = findViewById(R.id.challenges_icon_4)

        updateUI()

        coins.setOnClickListener {
            addXP(10)
        }

        challengesButton.setOnClickListener {
            navigateToChallenges()
        }

        val bmiCalculatorButton: ImageView = findViewById(R.id.bmi_calculator_icon_4)

        bmiCalculatorButton.setOnClickListener {
            val navigateToBMICalculator = Intent(this@HomePage, BMICalculator::class.java)
            startActivity(navigateToBMICalculator)
        }

        val workoutButton: ImageView = findViewById(R.id.workout_icon_4)

        workoutButton.setOnClickListener {
            val navigateToWorkout = Intent(this@HomePage, Workout::class.java)
            startActivity(navigateToWorkout)
        }

        val moreOptionsButton: ImageView = findViewById(R.id.more_options_icon_4)

        moreOptionsButton.setOnClickListener {
            val navigateToMoreOptions = Intent(this@HomePage, MoreOptions::class.java)
            startActivity(navigateToMoreOptions)
        }

    }

    private fun addXP(amount: Int) {
        currentXP += amount

        if (currentXP >= maxXP) {
            currentXP -= maxXP
            level++

            maxXP = (maxXP * 1.5).toInt()

            levelText.text = getString(R.string.level_text, level)
        }
        updateUI()
    }

    private fun updateUI() {
        progressBar.max = maxXP

        animateProgress(currentXP)

        val progressDisplay = "$currentXP/$maxXP"
        progressText.text = progressDisplay

        val xpToNextLevel = maxXP - currentXP
        val xpLeftDisplay = "$xpToNextLevel more XP to Lvl. ${level + 1}"
        xpLeftText.text = xpLeftDisplay
    }

    private fun animateProgress(currentXP: Int) {
        val animation = ObjectAnimator.ofInt(progressBar, "progress", lastXP, currentXP)
        animation.duration = 500L
        animation.interpolator = DecelerateInterpolator()
        animation.start()

        lastXP = currentXP
    }

    private fun navigateToChallenges() {
        val intent = Intent(this@HomePage, Challenges::class.java)
        intent.putExtra("current_xp", currentXP)
        intent.putExtra("max_xp", maxXP)
        intent.putExtra("LEVEL", level)
        startActivity(intent)
    }
}
