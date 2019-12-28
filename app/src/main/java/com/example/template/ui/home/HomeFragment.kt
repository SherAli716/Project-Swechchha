package com.example.template.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.template.ComListView
import com.example.template.R
import com.example.template.ui.Complains.Firstpg
import com.example.template.ui.familydetails.FamListMain

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(this, Observer {
//            textView.text = it

//
//        })

        val fam: Button =root.findViewById(R.id.family)
        fam.setOnClickListener(){
            Log.d("for","ok")
            val intent=Intent(this.context, FamListMain::class.java)
            startActivity(intent)


        }
        val click: Button =root.findViewById(R.id.buttoncom)
        click.setOnClickListener() {
            Log.d("for", "ok")
            val intent = Intent(this.context, ComListView::class.java)
            startActivity(intent)
        }
        val nag: Button =root.findViewById(R.id.Nagesh)
        nag.setOnClickListener() {
            Log.d("for", "ok")
            val intent = Intent(this.context,Firstpg::class.java)
            startActivity(intent)
        }
        return root


    }
}