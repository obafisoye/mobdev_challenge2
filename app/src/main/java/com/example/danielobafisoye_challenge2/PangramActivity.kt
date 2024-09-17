package com.example.danielobafisoye_challenge2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PangramActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pangram)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun isPangram(input: String): Boolean{
            val alphabet = ('a'..'z').toSet()
            val sanitized = input.lowercase().filter { it.isLetter() }.toSet()
            return alphabet == sanitized
        }

        val bundle:Bundle? = intent.extras
        val text_check:Any? = bundle?.get("text_check")
        val text_check_string = text_check.toString()

        var tv_pangram = findViewById<TextView>(R.id.tv_pangram)

        if (isPangram(text_check_string)){
            tv_pangram.text = "${text_check_string} is a pangram."
        }else{
            tv_pangram.text = "${text_check_string} is not a pangram."
        }

        tv_pangram.textSize = 20f
        tv_pangram.setTextColor(resources.getColor(R.color.black))
    }
}