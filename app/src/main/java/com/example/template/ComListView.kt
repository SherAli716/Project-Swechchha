package com.example.template

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

import org.json.JSONObject

class ComListView : AppCompatActivity() {
    var text="hey"
    lateinit var listView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        var listView =findViewById<ListView>(R.id.listView)
        var list = mutableListOf<Model>()
        var list1 = mutableListOf<String>()


//        list.add(Model("Complaint_Id:716",   "Started_at:712", R.drawable.img01 ))
//        list.add(Model("Complaint_Id:715",   "Started_at:712",R.drawable.img01))
//        list.add(Model("Complaint_Id:714",   "Started_at:712", R.drawable.img01))
//        list.add(Model("Complaint_Id:713",   "Started_at:712",R.drawable.img01 ))
//        list.add(Model("Complaint_Id:712",   "Started_at:712", R.drawable.img01))

        var json = (GetData().GETReq("http://192.168.43.176:8000/cbo/view_complains/"))
        Log.d("Json","$json")
        var jobject=JSONObject(json)
        Log.d("JSHer","${jobject.length()}")

//        for (i in 0 until jobject.length()){
//            Log.d("forl","$i")
//            val idata = jobject.keys()
//            Log.d("forl","${idata.toString()}")
//        }
        var keys = jobject.keys()
        Log.d("forl","${keys}")
        keys.forEach {
            val id = jobject.get(it)
            list1.add(it)
            Log.d("forl"," value : $it and $id")
            list.add(
                Model(
                    "Complaint id :$it",
                    "Started at: ${jobject.optJSONObject(it)!!.getString("started_at")}"
                )
            )



        }

//        val data = jobject.optJSONObject("25")!!.getString("started_at")
//        Log.d("JSHer",data)



        listView.adapter = MyListAdapter(this, R.layout.row, list)

        listView.setOnItemClickListener{parent, view, position, id ->

            //            if (position==0){
//
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//            }
//            if (position==1){
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//            }
//            if (position==2){
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//            }
//            if (position==3){
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//            }
//            if (position==4){
            text=jobject.optJSONObject(list1[position])!!.getString("text")
            val category=jobject.optJSONObject(list1[position])!!.getString("category")
            val started =jobject.optJSONObject(list1[position])!!.getString("started_at")


            val intent = Intent(this, ComplainView1::class.java)
            intent.putExtra("text",text)
            intent.putExtra("category",category)
            intent.putExtra("started_at",started)

            startActivity(intent)

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





