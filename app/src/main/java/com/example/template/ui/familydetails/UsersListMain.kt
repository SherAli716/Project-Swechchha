package com.example.template.ui.familydetails
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.template.R

import kotlinx.android.synthetic.main.activity_users_list_main.*
import org.json.JSONObject

class UsersListMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_list_main)
        var fname1:String =""
        var lname1:String =""
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rec_users.layoutManager = layoutManager
      //  val list = mutableListOf<Model>()


//        val adapter = Adapter_members(this, Suppliermem.members)
//        rec_users.adapter  = adapter
//        var res = JSONObject(APItest().GETReq("http://192.168.43.176:8000/cbo/view_family_details/"))
//        Log.d("JJJ","$res")
//        val keys = res.keys()
//        keys.forEach {
//            Log.d("kkk",it)
//            list.add(Model(res.optJSONObject(it)!!.getString("family_id").toInt(),res.optJSONObject(it)!!.getString("head")))
//        }


        fab2.setOnClickListener { view ->
            val intent = Intent(this, Add_New_Member::class.java)
            startActivity(intent)
        }
//
        val UserList = mutableListOf<Model_Members>()
        val Members_List1 = mutableListOf<String>()
        Log.d("kkk", "hi im here")
        var res = JSONObject(APItest().GETReq("http://192.168.43.176:8000/cbo/view_family_details/"))
        Log.d("JJJ", "$res")
        var fam_id: String = intent.getStringExtra("mem_id")
        Log.d("DEbug1", fam_id)
        val family_json = res.getString(fam_id)
        var keys = JSONObject(family_json)
        Log.d("KEY", keys.toString())
//        Log.d("TEST",keys)
//        keys.forEach{
//            list1.add(it)
//            Log.d("kkk",it)
//            val data=res.optJSONObject(it)!!
//
        val fam_data = keys.getString("family_data")
        val family_data11 = JSONObject(fam_data)
        val inner_keys = family_data11.keys()
        inner_keys.forEach {
            Log.d("Key", it)
            var user_details = family_data11.optJSONObject(it)
            var user_details_keys = user_details.keys()
            user_details_keys.forEach {
                  fname1 = user_details.getString("fname").capitalize()
                 lname1 = user_details.getString("lname").capitalize()
                Log.d("Name : ", fname1+" "+lname1)

            }
                  UserList.add(Model_Members(it.toInt(), "$fname1 $lname1",user_details))
//                   Log.d("Result",fname)
            //UserList.add(Model_Members(it.toInt(),family_data11.getJSONObject(it).getString("fname").capitalize()))
//               var fnameCaps= family_data11.getJSONObject(it).getString("fname").capitalize().toString()
//                var lnameCaps= family_data11.getJSONObject(it).getString("lname").capitalize().toString()
//                Log.d("Capitalise String",fnameCaps + lnameCaps)
//            }
//            val data2 = data1.optJSONArray("data")?.let { 0.until(it.length()).map { i->it.optJSONObject(i)
//            Log.d("data111",data2)            Log.d("data111",data2)


            val layoutManager = LinearLayoutManager(this)

            layoutManager.orientation = LinearLayoutManager.VERTICAL

            rec_users.layoutManager = layoutManager

            val adapter = Adapter_members(this, UserList)

            rec_users.adapter = adapter

            fab2.setOnClickListener { view ->
                val intent = Intent(this, Add_New_Member::class.java)
                startActivity(intent)
            }


        }



    }
}










