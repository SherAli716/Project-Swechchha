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

//        var json = (GetData().GETReq("http://192.168.43.176:8000/cbo/view_complains/"))
        Message_id.text = intent.getStringExtra("text")

//        ward.text = JSONObject(json).getJSONObject("25").getString("started_at")

        category.text = intent.getStringExtra("category")
        started_at.text = intent.getStringExtra("started_at")
//        var jobject=JSONObject(json)
//        var keys = jobject.keys()
//        Log.d("forl","${keys}")
//        keys.forEach {
//            val id = jobject.get(it)
//            Log.d("forl"," value : $it and $i d")
//            MessageId.text = JSONObject(json).getJSONObject("$it").getString("text")
//
//        }


        Reply.setOnClickListener() {
            //            val intent = Intent(this, Main3Activity::class.java)
//            startActivity(intent)
            val toast = Toast.makeText(applicationContext, "Reply send to the user", Toast.LENGTH_SHORT)
            toast.show()
        }
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
