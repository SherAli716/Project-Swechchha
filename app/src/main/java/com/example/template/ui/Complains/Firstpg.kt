package com.example.template.ui.Complains


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import com.example.template.R
import kotlinx.android.synthetic.main.activity_firstpg.*
import kotlinx.android.synthetic.main.activity_form1.*

/*
This is the first page which has two buttons roles and posts.
On clicking the roles button Form1 opens and on clicking posts button ListviewF2 which has the name of all posts opens.
 */
class Firstpg : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firstpg)

        role.setOnClickListener{
            val intent = Intent(this, Form1::class.java)
            startActivity(intent)
        }
        post.setOnClickListener{
            val intent = Intent(this, ListViewF2::class.java)
            startActivity(intent)
        }
    }
}