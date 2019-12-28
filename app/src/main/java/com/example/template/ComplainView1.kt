package com.example.template
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.template.R
import kotlinx.android.synthetic.main.activity_complain_view.*


import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject

import java.io.IOException
import java.lang.IllegalStateException

class ComplainView1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complain_view)

        Message_id.text = intent.getStringExtra("text")
        category.text = intent.getStringExtra("category")
        started_at.text = intent.getStringExtra("started_at")

/*here we are putting  the value into the required position which we have get from the json*/

        Reply.setOnClickListener() {
            //            val intent = Intent(this, Main3Activity::class.java)
//            startActivity(intent)
            val toast = Toast.makeText(applicationContext, "Reply send to the user", Toast.LENGTH_SHORT)
            toast.show()
        }
        /*For Toast Message */
        send.setOnClickListener() {
            //            val intent = Intent(this, Main4Activity::class.java)
//            startActivity(intent)
            val toast = Toast.makeText(applicationContext, "Message forwarded to higher Authority", Toast.LENGTH_SHORT)
            toast.show()

        }
        img.setOnClickListener() {
//            val intent = Intent(this,activity::class.java)
//            startActivity(intent)
            val toast = Toast.makeText(applicationContext, "Null", Toast.LENGTH_SHORT)
            toast.show()

        }
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
