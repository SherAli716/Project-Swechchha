package com.example.template.ui.familydetails

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList
import androidx.recyclerview.widget.RecyclerView


import kotlinx.android.synthetic.main.list_families.view.*
import android.util.Log
import com.example.template.R


class FamilyAdapter(val context:Context, val families: List<Model_families>) : RecyclerView.Adapter<FamilyAdapter.MyViewHolder>(){
     var famid_text:String="family_id"

    lateinit var famFilter:ArrayList<Model_families>

    lateinit var inflater: LayoutInflater




    init {
        inflater = LayoutInflater.from(context)
        this.famFilter=ArrayList<Model_families>()
        this.famFilter.addAll(families)
    }



    private var familylist: ArrayList<Model_families>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_families,parent,false)
        return MyViewHolder(view)


    }


    override fun getItemCount(): Int {
        return families.size
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val famhead = families[position].famhead
        val famid = families[position].famid
        holder.setData(Model_families(famid,famhead), position)
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var currentId: Int? = 0
        var CurrentHead:String = ""


        init {
            itemView.setOnClickListener{
                //Toast.makeText(context, currentWard!!.title + "Clicked!",Toast.LENGTH_SHORT).show()
                Log.d("ID",this.currentId.toString())
                val intent =  Intent(context,UsersListMain::class.java)
                intent.putExtra("mem_id",this.currentId.toString())
                context.startActivity(intent)




            }
        }
        fun UpdateList(newList:List<Model_families>) {
            familylist = ArrayList()
            familylist!!.addAll(newList)
            notifyDataSetChanged()
        }


        fun setData(fam: Model_families, pos: Int){
            itemView.famhead1.text = fam!!.famhead
            itemView.famid1.text=fam!!.famid.toString()
//            Log.d("member13","${fam!!.famid.toString()}")
            famid_text=pos.toString()
            this.currentId=  fam.famid
            this.CurrentHead = fam.famhead
        }
    }


}
