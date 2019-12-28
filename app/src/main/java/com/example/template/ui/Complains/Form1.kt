package com.example.template.ui.Complains

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.template.R
import kotlinx.android.synthetic.main.activity_form1.*

class Form1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form1)

        addF1.setOnClickListener {
            val intent = Intent(this, ListViewF1::class.java)
            startActivity(intent)
        }
    }
}