package com.example.template.ui.familydetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.template.R
import kotlinx.android.synthetic.main.activity_family_list.*
import org.json.JSONObject

class FamListMain : AppCompatActivity() {


    private var list: RecyclerView? = null
    private var searchinput: EditText? = null
    private var recyclerAdapter: FamilyAdapter? = null
    var fname1: String = ""
    var lname1: String = ""
    var fam_id1:String=""
    var is_head:String=""
    var listfam: ArrayList<Model_families>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family_list)
        searchinput = findViewById(R.id.search_fam)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()

        StrictMode.setThreadPolicy(policy)
        val famlist = mutableListOf<Model_families>()
        val family_list1 = mutableListOf<String>()
        Log.d("kkk", "hi im here")
//        var res = JSONObject(APItest().GETReq("http://192.168.38.233:8000/cbo/view_family_details/"))
//        Log.d("JJJ","$res")
//        val keys = res.keys()


        val UserList = mutableListOf<Model_Members>()
        val Members_List1 = mutableListOf<String>()
        Log.d("kkk", "hi im here")
        var res = JSONObject(APItest().GETReq("http://192.168.43.176:8000/cbo/view_family_details/"))
        Log.d("JJJ", "$res")
        val fam_id=res.keys()

        fam_id.forEach {
            val head=res.optJSONObject(it)
            fam_id1=head["family_id"].toString()
            Log.d("hello","${head["family_id"]}")

            val keys=head.keys()
            Log.d("hello11","$keys")

            keys.forEach {
                val family_data=head.optJSONObject("family_data")
                Log.d("family_data","$family_data")
                val mem=family_data.keys()
                mem.forEach {
                    val head=family_data.optJSONObject(it)
                    Log.d("head","$head")
                     is_head=head["is_head"].toString()
                    Log.d("is_head","$is_head")
                    if (is_head.toInt()==1) {
                        fname1 = head["fname"].toString().capitalize()
                        lname1 = head["lname"].toString().capitalize()
                        Log.d("fname1", fname1)
                        Log.d("lname1", lname1)

                    }


                }
            }

            famlist.add(Model_families(fam_id1.toInt(),"$fname1 $lname1"))
           // UserList.add(Model_Members(it.toInt(), "$fname1 $lname1"))

        }
//        Log.d("DEbug1", fam_id)
//        val family_json = res.getString(fam_id)
//        var keys = JSONObject(family_json)
//        Log.d("KEY", keys.toString())
////        Log.d("TEST",keys)
////        keys.forEach{
////            list1.add(it)
////            Log.d("kkk",it)
////            val data=res.optJSONObject(it)!!
////
//        val fam_data = keys.getString("family_data")
//        val family_data11 = JSONObject(fam_data)
//        val inner_keys = family_data11.keys()
//        inner_keys.forEach {
//            Log.d("Key", it)
//            var user_details = family_data11.optJSONObject(it)
//            var user_details_keys = user_details.keys()
//            user_details_keys.forEach {
//                //                fname1 = user_details.getString("fname").capitalize()
////                lname1 = user_details.getString("lname").capitalize()
//                Log.d("Name1212 : ", fname1+" "+lname1)
//
//            }
////            UserList.add(Model_Members(it.toInt(), "$fname1 $lname1"))
//

//        keys.forEach {
//            family_list1.add(it)
//
//            Log.d("kkk",it)
//            var an=(Model_families(it.toInt(),res.optJSONObject(it)!!.getString("is_head")    ))
//            Log.d("MMM","$an")
//   }

            val layoutManager = LinearLayoutManager(this)

            layoutManager.orientation = LinearLayoutManager.VERTICAL

            rec1.layoutManager = layoutManager

            val adapter = FamilyAdapter(this, famlist)

            rec1.adapter = adapter

            fab1.setOnClickListener { view ->
                val intent = Intent(this, AddFam_CT::class.java)
                startActivity(intent)
            }


        }

        }


//}







