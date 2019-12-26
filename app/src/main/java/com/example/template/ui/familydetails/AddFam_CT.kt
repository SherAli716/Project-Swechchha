package com.example.template.ui.familydetails
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.View
import android.widget.*
import androidx.navigation.ui.AppBarConfiguration
import com.example.template.R

import kotlinx.android.synthetic.main.activity_add_fam__ct.*
import org.json.JSONObject

class AddFam_CT : AppCompatActivity() {

    lateinit var option: Spinner
    lateinit var result: TextView
    lateinit var familyid: TextView
    lateinit var cityfam:EditText
    lateinit var townfam:EditText
    lateinit var addressfam:EditText
    lateinit var toiletavailfam: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_fam__ct)
        Submitfam.setOnClickListener{
            view ->
            val intent = Intent(this, Add_New_Member::class.java)
            this.startActivity(intent)
            val toast=Toast.makeText(applicationContext,"FFF",Toast.LENGTH_SHORT)
            toast.show()
                        //val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
//
//            StrictMode.setThreadPolicy(policy)
//            var res = JSONObject(APItest().GETReq("http://192.168.43.176:8000/cbo/view_family_details/"))
//            Log.d("JJJ","$res")
//            var tes = JSONObject(APItest().POSTReq("http://192.168.43.176:8000/cbo/view_family_details/",json ))
        }

        familyid=findViewById(R.id.fam_id1)
        cityfam=findViewById(R.id.editcity)
        townfam=findViewById(R.id.edittown)
        addressfam=findViewById(R.id.editADD)
        toiletavailfam=findViewById(R.id.spin1)



        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        option=findViewById(R.id.spin1) as Spinner
        result=findViewById(R.id.toiletAvail)as TextView
        val options = arrayOf("Is Toilet Available","Yes","No")
        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options) as SpinnerAdapter?
        option.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            ) {
                result.text = options.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text = "Please select an option"
            }
        }
    }

    }

