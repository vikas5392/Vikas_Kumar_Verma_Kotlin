package com.training.to_doapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var enterText:EditText
    lateinit var list_view:ListView
    lateinit var column:Columns
    lateinit var handler:MyHandler
    lateinit var todo_list:ArrayList<Columns>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enterText=findViewById(R.id.editTextTextPersonName)
        list_view=findViewById(R.id.listView)
        column=Columns()
        handler= MyHandler(this)
        todo_list= ArrayList<Columns>()

    }

    fun save(view: View){
        var str:String?=enterText.text.toString()
        column.entry=str
        handler.addEntries(column)

        todo_list=handler.getEntries()
        val al=ArrayList<String> ()
        for(c:Columns in todo_list){
            c.entry?.let { al.add(it) }
        }
        val  adapter= ArrayAdapter <String>(this,android.R.layout.simple_list_item_1,al)
        list_view.adapter=adapter
    }
}