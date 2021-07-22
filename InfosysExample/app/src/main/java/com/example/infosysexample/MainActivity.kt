package com.example.infosysexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.infosysexample.Utils.VolleyClient
import com.example.infosysexample.ui.main.MainFragment



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        //we need to make a volley queue at the very beginning
        VolleyClient.setQueue(this)
    }
}