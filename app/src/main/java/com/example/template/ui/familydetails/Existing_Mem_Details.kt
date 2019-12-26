package com.example.template.ui.familydetails
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import com.example.template.R
import kotlinx.android.synthetic.main.activity_existing__mem__details.*

import org.json.JSONObject

class Existing_Mem_Details : AppCompatActivity() {

    lateinit var rg_gender: RadioGroup
    lateinit var rb_male: RadioButton
    lateinit var rb_female: RadioButton

    //Radio(Specially Abled Status)
    lateinit var rg_abled: RadioGroup
    lateinit var rb_yes: RadioButton
    lateinit var rb_no: RadioButton

    //spinner(Qualification)
    //lateinit var option: Spinner

    //Spinner(Unique_id)
    lateinit var option2: Spinner


//    var ration: String = ""
//    var address1:String=""
//    var caste1:String=""
//    var religion1:String=""
//    var emailId:String=""
//    var Income:String=""
//    var contact:String=""
//    var mem_id1:String=""

    //-------------------------------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_existing__mem__details)

        //radio (gender)
        rg_gender = findViewById(R.id.rg_gender1)
        rb_male = findViewById(R.id.rb_male1)
        rb_female = findViewById(R.id.rb_female1)

        //radio (specially abled status)
        rg_abled = findViewById(R.id.rg_spec_able1)
        rb_yes = findViewById(R.id.rb_spec_yes1)
        rb_no = findViewById(R.id.rb_spec_no1)


        val UserList = mutableListOf<Model_Members>()
        val Members_List1 = mutableListOf<String>()
        Log.d("kkk", "hi im here")
        Log.d("Debug",intent.getStringExtra("member_id1"))
        Log.d("Debug",intent.getStringExtra("user_json"))
        var user_details = JSONObject(intent.getStringExtra("user_json"))

        Log.d("Fname",user_details.getString("fname"))
        Log.d("Fname",user_details.getString("lname"))
        Log.d("Fname",user_details.getString("ration_id"))
        Log.d("Fname",user_details.getString("address"))
        var fname2=user_details.getString("fname")
        var lname2=user_details.getString("lname")
        var mname2=user_details.getString("mname")
        var ration=user_details.getString("ration_id")
       var addressExist=user_details.getString("address")
       var casteExist=user_details.getString("caste")
      var  religionExist=user_details.getString("religion")
      var  contactExist=user_details.getString("mobile_no")
       var IncomeExist=user_details.getString("yearly_income")
      var  emailIdExist=user_details.getString("email_id")
        var genderExist=user_details.getString("gender")
        var birthdateExist=user_details.getString("dob")
        var ablestatusExist=user_details.getString("specially_abled_status")
        var isworkExist=user_details.getString("is_working")
        fname1.setText(fname2)
        lname1.setText(lname2)
        ration1.setText(ration)
        address1.setText(addressExist)
        caste1.setText(casteExist)
        religion1.setText(religionExist)
        contact1.setText(contactExist)
        income1.setText(IncomeExist)
        email1.setText(emailIdExist)
        mname1.setText(mname2)
        dob1.setText(birthdateExist)
        if("M".equals(genderExist)){
            rb_male1.isChecked = true
        }
        else if("F".equals(genderExist)){
            rb_female1.isChecked=(true)
        }

        if("1".equals(isworkExist)){
            rb_is_work_yes1.isChecked=true
        }
        else if("0".equals(isworkExist)){
            rb_is_work_no1.isChecked=true
        }

        if("1".equals(ablestatusExist)){
            rb_spec_yes1.isChecked=true
        }
        else if("0".equals(ablestatusExist)){
            rb_spec_no1.isChecked = true
        }


    }
}
