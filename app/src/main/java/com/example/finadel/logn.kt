package com.example.finadel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finadel.databinding.ActivityLoginBinding
import com.example.finadel.databinding.ActivityLognBinding

class logn : AppCompatActivity() {
    private lateinit var binding: ActivityLognBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLognBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button3?.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

    }
}