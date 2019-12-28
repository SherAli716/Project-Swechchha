package com.example.template.ui.Complains


import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.template.R
import org.json.JSONObject

/*
This is the list of all the posts and is dynamic.
on  clicking any post it opens up form2.
 */

class ListViewF2 : AppCompatActivity() {
    var text=""
    lateinit var listView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_f2)
        var listView = findViewById<ListView>(R.id.ListView2)
        var list = mutableListOf<Model2>()
        var list1 = mutableListOf<String>()


        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var json = (APICalls().get("http://192.168.43.176:8000/cbo/view_role_mapping/"))
        var jobject=JSONObject(json)
        Log.d("JSHer","$jobject")


        var keys = jobject.keys()
        Log.d("forl","${keys}")
        keys.forEach {
            val id = jobject.get(it)
            list1.add(it)
            Log.d("forl", " value : $it and $id")
//            list.add(Model2("Complaint id :$it","Started at: ${jobject.optJSONObject(it)!!.getString("started_at")}"))
            val jsonObject = JSONObject(id.toString())
            val idkeys = jsonObject.keys()
            idkeys.forEach {
                Log.d("for", it)
                list.add(Model2(it))
            }
        }

        listView.adapter = MyListAdapter2(this, R.layout.row, list)

        listView.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(this, Form2::class.java)
            startActivity(intent)
        }


    }


}
