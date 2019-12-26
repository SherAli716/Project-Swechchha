package com.example.template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.template.R

class   ImageView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)

        val actionbar= supportActionBar
        actionbar!!.title ="Main Activity"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
        return true
    }
}

