package com.training.sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity2 : AppCompatActivity() {
    lateinit var lv:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val i=intent
       var str:String?=i.getStringExtra("firstText")

        var list=ArrayList<String>()
        if (str != null) {
            list.add(str)
        }
        lv=findViewById(R.id.listView)
       var my_adapter= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list)
        lv.adapter=my_adapter

    }
    fun goHome(view: View) {
      val  intent2= Intent(this,MainActivity::class.java)
        startActivity(intent2)
    }
}