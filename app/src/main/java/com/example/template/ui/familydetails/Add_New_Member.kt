package com.example.template.ui.familydetails


import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


import com.example.template.R
import kotlinx.android.synthetic.main.activity_add__new__member.*
import org.json.JSONObject

class Add_New_Member : AppCompatActivity() {

    //Radio(Gender)
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
    var fname1: String = ""
    var lname1: String = ""
    var ration: String = ""
    var address1:String=""
    var caste1:String=""
    var religion1:String=""
    var emailId:String=""
    var Income:String=""
    var contact:String=""
    var mem_id1:String=""

    //-------------------------------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add__new__member)

        //radio (gender)
        rg_gender = findViewById(R.id.rg_gender2)
        rb_male = findViewById(R.id.rb_male2)
        rb_female = findViewById(R.id.rb_female2)

        //radio (specially abled status)
        rg_abled = findViewById(R.id.rg_spec_able)
        rb_yes = findViewById(R.id.rb_spec_yes)
        rb_no = findViewById(R.id.rb_spec_no)

        //calendar
        val c = java.util.Calendar.getInstance()
        val year = c.get(java.util.Calendar.YEAR)
        val month = c.get(java.util.Calendar.MONTH)
        val day = c.get(java.util.Calendar.DAY_OF_MONTH)

        btn_dob2.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                dob11.setText(""+mDay+"/"+(mMonth+1)+"/"+mYear)
            }, year, month, day)
            dpd.show()
        }

    }
}
