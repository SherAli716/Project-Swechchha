package com.example.template.ui.Complains

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

import com.example.template.R


class MyListAdapter2(var mCtx:Context, var resource:Int, var items:List<Model2>)
    :ArrayAdapter<Model2>( mCtx , resource , items ){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater :LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(resource , null )

        var mItems: Model2 = items[position]
        val textView1 :TextView=view.findViewById(R.id.textView)
        textView1.text = mItems.title



        return view
    }

}