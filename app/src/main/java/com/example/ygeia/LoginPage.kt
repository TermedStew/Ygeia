package com.example.ygeia

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_page)

//        val welcomeText: TextView = findViewById(R.id.text_3)
//        val textWelcome = "Welcome Back"
//        val spannableWelcome = SpannableString(textWelcome)
//
//        spannableWelcome.setSpan(ForegroundColorSpan(Color.parseColor("#81DE75")), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//        welcomeText.text = spannableWelcome

        // Clickable text
        val signupText: TextView = findViewById(R.id.signup_text_3)
        val spannableBuilder = SpannableStringBuilder()

        val signupText3p1 = "Don't have an account? " // Login text in SignUp page to be edited here
        val spanText1 = SpannableString(signupText3p1)
        spannableBuilder.append(spanText1)

        // Clickable text code
        val loginTextClickable = "Sign Up"
        val spanTextClickable = SpannableString(loginTextClickable)

        spanTextClickable.setSpan(ForegroundColorSpan(Color.parseColor("#8CD9FF")), 0, loginTextClickable.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val navigateToSignUpPage = Intent(this@LoginPage, SignUpPage::class.java)
                startActivity(navigateToSignUpPage)
            }

            override fun updateDrawState(ds: android.text.TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false // Remove underline
                ds.color = Color.parseColor("#8CD9FF") // Set color when clicked (does not work, I don't know why...)
            }
        }

        spanTextClickable.setSpan(
            clickableSpan,
            0,
            loginTextClickable.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannableBuilder.append(spanTextClickable)

        // Set spannable text to needed text
        signupText.text = spannableBuilder
        signupText.movementMethod = LinkMovementMethod.getInstance()

        val loginButton: Button = findViewById(R.id.login_button_3)

        loginButton.setOnClickListener {
            val navigateToHomePage = Intent(this@LoginPage, HomePage::class.java)
            startActivity(navigateToHomePage)
        }
    }
}