package com.example.template.ui.Complains

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.template.ComListView

import com.example.template.R

class ComplainFragment: Fragment() {

    private lateinit var complainViewModel: ComplainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {


        complainViewModel =
            ViewModelProviders.of(this).get(ComplainViewModel::class.java)
        val root = inflater.inflate(R.layout.activity_complain_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.text_complain)
        complainViewModel.text.observe(this, Observer {
            textView.text = it

        })

        val comp: Button =root.findViewById(R.id.buttoncom)
        comp.setOnClickListener(){
            Log.d("for","ok")
            val intent=Intent(this.context,ComListView::class.java)
            startActivity(intent)


        }
//        val root = inflater.inflate(R.layout.activity_list_view,container,false)

        return root



    }
}