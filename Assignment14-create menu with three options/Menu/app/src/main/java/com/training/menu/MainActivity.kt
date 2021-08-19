package com.training.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var menuview:View
    lateinit var list_v:ListView
    lateinit var FruitList:ArrayList<String>
   lateinit var MovieList:ArrayList<String>
   lateinit var m_adapter:ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
list_v=findViewById(R.id.listView)
        FruitList=ArrayList<String>()
        MovieList=ArrayList<String>()
        FruitList.add("Mango")
        FruitList.add("Apple")
        FruitList.add("Guava")
        FruitList.add("Kiwi")
        FruitList.add("Papaya")

        MovieList.add("Interstellar")
        MovieList.add("A quiet place")
        MovieList.add("Exam")
        MovieList.add("Spiral")
        MovieList.add("Rush hour")


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater:MenuInflater=menuInflater
        inflater.inflate(R.menu.menu_layout,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId)
        {
            R.id.movies ->{
            m_adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,MovieList)
                list_v.adapter=m_adapter
            return true
        }
          R.id.fruits->{
              m_adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,FruitList)
              list_v.adapter=m_adapter
              return true
          }
           R.id.close->{
               finish()
               System.exit(0)
               return true
           }
            else->  return super.onOptionsItemSelected(item)
        }
    }
}