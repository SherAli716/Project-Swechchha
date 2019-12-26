package com.example.template

import androidx.appcompat.app.AppCompatActivity
import android.os.StrictMode
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

public class GetData : AppCompatActivity() {

    public fun GETReq(x: String): String {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var myresponse: String
        myresponse = ""
        var client = OkHttpClient()
        Log.d("Debug", "Error1")

        // Creating request
        var request = Request.Builder()
            .url(x)
            .build()
        Log.d("Debug", "Error2")
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("error")
//            Log.d("Respomse",response.body()!!.string())
            return response.body()!!.string()

        }
    }
}
