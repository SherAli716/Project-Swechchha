package com.example.template.ui.familydetails
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException

public class APItest : AppCompatActivity()

{
    public fun GETReq(URL: String) : String {
        var myresponse: String
        myresponse = ""
        var client = OkHttpClient()


        // Creating request
        var request = Request.Builder()
                .url(URL)
                .build()



        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("error")

            return response.body()!!.string()
        }
    }




    public fun POSTReq(u: String,json1: String) : String
    {

// Create client
        val client = OkHttpClient()

// Creating request body i.e. adding the data in json format to send
        val mediaType = MediaType.parse("application/json; charset=utf-8")

        val body = RequestBody.create(mediaType, json1)
        Log.d("Response",json1)
        var myresponse : String = ""
// Building the request
        var request = Request.Builder()
                .url(u).post(body)
                .build()


        client.newCall(request).execute().use { response ->
            if(!response.isSuccessful) throw IOException("error")

            return response.body()!!.string()

        }
    }
}
