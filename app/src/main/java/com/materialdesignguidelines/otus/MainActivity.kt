package com.materialdesignguidelines.otus

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setInsets()

        setSplashScreenLoadingParameters()
        setErrorListener()
        setButtonLogin()
    }

    private fun setButtonLogin() {
        findViewById<Button>(R.id.sign_in_button).setOnClickListener {
            startActivity(Intent(this, BottomAppBarActivity::class.java))
        }
    }

    private fun setErrorListener() {
        findViewById<TextInputEditText>(R.id.password_input_edittext).addTextChangedListener { text ->
            findViewById<TextInputLayout>(R.id.password_edittext).apply {
                error = if (text != null && text.length < 10) null else getString(R.string.incorrect_password_error)
            }
        }
    }

    private fun setSplashScreenLoadingParameters() {
        var isHideSplashScreen = false

        object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                isHideSplashScreen = true
            }
        }.start()

        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (isHideSplashScreen) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else {
                        false
                    }
                }
            }
        )
    }

    private fun setInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}