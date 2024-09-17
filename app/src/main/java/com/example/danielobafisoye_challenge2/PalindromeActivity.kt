package com.example.danielobafisoye_challenge2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PalindromeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_palindrome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun isPalindrome(input: String): Boolean{
            val sanitized = input.replace("""\W+""".toRegex(), "").lowercase()
            return sanitized == sanitized.reversed()
        }

        val bundle:Bundle? = intent.extras
        val text_check:Any? = bundle?.get("text_check")
        val text_check_string = text_check.toString()

        var tv_palindrome = findViewById<TextView>(R.id.tv_palindrome)

        if (isPalindrome(text_check_string)) {
            tv_palindrome.text = "${text_check_string} is a palindrome."
        }else{
            tv_palindrome.text = "${text_check_string} is not a palindrome."
        }

        tv_palindrome.textSize = 20f
        tv_palindrome.setTextColor(resources.getColor(R.color.black))
    }
}