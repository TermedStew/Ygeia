package com.example.ygeia

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class WelcomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.welcome_page)

//        val welcomeText: TextView = findViewById(R.id.text_1)
//        val text = "New to Ygeia? Sign Up Here." // Welcome Page (refer to Figma) Sign Up text to be edited here
//        val spannable = SpannableString(text)
//
//        spannable.setSpan(ForegroundColorSpan(Color.parseColor("#81DE75")), 7, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//        welcomeText.text = spannable

        val signUpButton: Button = findViewById(R.id.sign_up_button_1)

        signUpButton.setOnClickListener {
            val navigateToSignUpPage = Intent(this@WelcomePage, SignUpPage::class.java)
            startActivity(navigateToSignUpPage)
        }

        val loginButton: Button = findViewById(R.id.login_button_1)

        loginButton.setOnClickListener {
            val navigateToLoginPage = Intent(this@WelcomePage, LoginPage::class.java)
            startActivity(navigateToLoginPage)
        }
    }
}
