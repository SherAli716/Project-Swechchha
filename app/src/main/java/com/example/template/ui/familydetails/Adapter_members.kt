package com.example.template.ui.familydetails

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

import com.example.template.R

import kotlinx.android.synthetic.main.list_families.view.*
import kotlinx.android.synthetic.main.list_users.view.*
import org.json.JSONObject


class Adapter_members(val context:Context, val members: List<Model_Members>) : RecyclerView.Adapter<Adapter_members.MyViewHolder>(){

    var memid_text:String="mem_id"
   // var famid_text:String="family_id"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_users,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return members.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val memid=members[position].memid
        val membername = members[position].membername
        val user_details = members[position].user_details
        holder.setData(Model_Members(memid ,membername,user_details),position)
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var currentId: Int? = 0
        var CurrentMember:String = ""
        var currentUSerDetails:JSONObject = JSONObject()
        init {
            itemView.editmem1.setOnClickListener{
                //Toast.makeText(context, currentWard!!.title + "Clicked!",Toast.LENGTH_SHORT).show()
                val intent =  Intent(context,Existing_Mem_Details::class.java)
                intent.putExtra("member_id1",this.currentId.toString())
                intent.putExtra("user_json",this.currentUSerDetails.toString())
                context.startActivity(intent)


            }
        }

        fun setData(members: Model_Members,position: Int){
            itemView.memname1.text = members!!.membername
            itemView.memid1.text = members!!.memid.toString()
            memid_text=position.toString()
            this.currentId=members.memid
            this.CurrentMember = members.membername
            this.currentUSerDetails = members.user_details

        }
    }
}