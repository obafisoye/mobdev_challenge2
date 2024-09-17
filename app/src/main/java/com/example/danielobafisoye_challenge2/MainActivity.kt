package com.example.danielobafisoye_challenge2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val et_Enter: TextView = findViewById(R.id.et_Enter)
        val btn_Palindrome: Button = findViewById(R.id.btn_Palindrome)
        val btn_Pangram: Button = findViewById(R.id.btn_Pangram)

        et_Enter.hint = "Enter a word or phrase to be checked"
        et_Enter.textSize = 17f
        et_Enter.setTextColor(resources.getColor(R.color.grey))

        btn_Palindrome.setOnClickListener(){
            var intent = Intent(this, PalindromeActivity::class.java)
            intent.putExtra("text_check", et_Enter.text.toString())

            startActivity(intent)
        }

        btn_Pangram.setOnClickListener(){
            var intent = Intent(this, PangramActivity::class.java)
            intent.putExtra("text_check", et_Enter.text.toString())

            startActivity(intent)
        }
    }
}