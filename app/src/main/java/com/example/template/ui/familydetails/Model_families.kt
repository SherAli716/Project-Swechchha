package com.example.template.ui.familydetails

data class Model_families(var  famid: Int,var famhead:String)

object RealData {
    val families = mutableListOf<Model_families>()

}

//    for(i in 1..51)
//    {
//        wards += Model("Ward_$i")
//    }