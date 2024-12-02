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

class SignUpPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.sign_up_page)

//        val signUpText: TextView = findViewById(R.id.text_2)
//        val text = "Sign Up" // SignUp Page (refer to Figma) Sign Up text to be edited here
//        val spannable = SpannableString(text)
//
//        // Change colors of specific words using spannable here
//        spannable.setSpan(ForegroundColorSpan(Color.parseColor("#81DE75")), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//        signUpText.text = spannable

        // Clickable text
        val loginText: TextView = findViewById(R.id.login_text_2)
        val spannableBuilder = SpannableStringBuilder()

        val loginText2p1 = "Already have an account? " // Login text in SignUp page to be edited here
        val spanText1 = SpannableString(loginText2p1)
        spannableBuilder.append(spanText1)

        // Clickable text code
        val loginTextClickable = "Login here"
        val spanTextClickable = SpannableString(loginTextClickable)

        spanTextClickable.setSpan(ForegroundColorSpan(Color.parseColor("#8CD9FF")), 0, loginTextClickable.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val navigateToLoginPage = Intent(this@SignUpPage, LoginPage::class.java)
                startActivity(navigateToLoginPage)
            }

            override fun updateDrawState(ds: android.text.TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false // Remove underline
                ds.color = Color.parseColor("#8CD9FF") // Set color when clicked (does not work, I don't know why...)
            }
        }

        spanTextClickable.setSpan(clickableSpan, 0, loginTextClickable.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannableBuilder.append(spanTextClickable)

        // Set spannable text to needed text
        loginText.text = spannableBuilder
        loginText.movementMethod = LinkMovementMethod.getInstance()

        val signUpButton: Button = findViewById(R.id.sign_up_button_2)

        signUpButton.setOnClickListener {
            val navigateToHomePage = Intent(this@SignUpPage, HomePage::class.java)
            startActivity(navigateToHomePage)
        }
    }
}


