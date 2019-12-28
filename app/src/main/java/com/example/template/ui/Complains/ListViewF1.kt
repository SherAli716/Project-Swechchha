package com.example.template.ui.Complains

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

import com.example.template.R


/* This has the name of all the roles and is static.
 */
class ListViewF1 : AppCompatActivity() {
    var text=""
    lateinit var listView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_f1)
        var listView =findViewById<ListView>(R.id.ListView1)
        var list = mutableListOf<Model2>()
//        var list1 = mutableListOf<String>()

        list.add(Model2("Add_CBO_President"))
        list.add(Model2("CBO_Grievance_Redresal_Officer"))
        list.add(Model2("Federation_Representative"))
        list.add(Model2("CRUD_on_CBO_Officers"))
        list.add(Model2("Update_Emergency_Number"))
        list.add(Model2("Add_Federation_Member"))
        list.add(Model2("Issue_pass_family"))
        list.add(Model2("CRUD(Family_Details,Payments)"))
        list.add(Model2("CRUD(User_Details"))
        list.add(Model2("Find_NumberOf_passholders_CT"))
        list.add(Model2("Log_payment_random_users"))
        list.add(Model2("Log_payment_system_users"))
        list.add(Model2("Log_expense"))
        list.add(Model2("Log_user_using_CT"))
        list.add(Model2("CRUD_onCleaning_by_Cleaners"))
        list.add(Model2("Block_user_fake_complaints"))
        list.add(Model2("CRUD_Cleaners"))
        list.add(Model2("Status_equipments_consumaables"))
        list.add(Model2("Status_safety_equipments"))
        list.add(Model2("log_in_out_break_records"))
        list.add(Model2("upload_cleaning_schedule"))
        list.add(Model2("Download_reports_CBO_level"))
        list.add(Model2("Download_reports_MCGM_level"))
        list.add(Model2("user"))



        listView.adapter = MyListAdapter2(this,R.layout.nageshrow,list)

        listView.setOnItemClickListener{parent, view, position, id ->


            val intent = Intent(this, Form1::class.java)
            startActivity(intent)
        }

    }


}
