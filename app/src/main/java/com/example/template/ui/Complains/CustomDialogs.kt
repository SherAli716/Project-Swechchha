package com.example.template.ui.Complains


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.template.R
import kotlinx.android.synthetic.main.activity_custom_dialogs.*


@SuppressLint("Registered")
class CustomDialogs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_dialogs)

        nobtn.setOnClickListener{
            val intent= Intent(this, Form2::class.java)
            startActivity(intent)

        }
    }
}