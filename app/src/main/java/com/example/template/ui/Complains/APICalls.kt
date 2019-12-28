package com.example.template.ui.Complains



import android.app.DownloadManager
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


public class APICalls {
    var return_response = ""

    //get data
    public fun get(url: String) : String{

        // Creating Client
        var client = OkHttpClient()

        // Creating request
        var request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Error")
            try {
                return response.body()!!.string()
            } catch (e: Exception) {
                Log.d("Error", e.toString())
                return "Error"
            }

        }

        Log.d("request","request_build")

        return return_response
    }

}