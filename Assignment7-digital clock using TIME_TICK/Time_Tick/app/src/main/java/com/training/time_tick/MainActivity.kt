package com.training.time_tick

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var date_Format:SimpleDateFormat
    lateinit var timeText:TextView
   lateinit var receiver:BroadcastReceiver

    //make a broadcast receiver anonomus class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timeText=findViewById(R.id.textView)
        date_Format= SimpleDateFormat("HH:mm")

        timeText.text=date_Format.format(Date())
         receiver=object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                // TODO("Not yet implemented")
                if(intent!!.action!!.compareTo(Intent.ACTION_TIME_TICK)==0)
                    timeText.text=date_Format.format(Date())
            }
        }
        registerReceiver(receiver,IntentFilter(Intent.ACTION_TIME_TICK))

    }
    override fun onStop() {
        super.onStop()
        if (receiver != null)
        unregisterReceiver(receiver)
    }
}

