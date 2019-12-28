package com.example.template.ui.Complains


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.template.R
import kotlinx.android.synthetic.main.activity_form2.*

/*
This is opened after clicking on posts.
On clicking the add button a dialog box is opened.
 */
class Form2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form2)

        addF2.setOnClickListener {
            val intent = Intent(this, CustomDialogs::class.java)
            startActivity(intent)
        }
    }
}