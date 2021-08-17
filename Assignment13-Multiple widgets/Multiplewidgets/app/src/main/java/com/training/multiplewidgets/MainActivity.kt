package com.training.multiplewidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
   fun imageClick(view: View){
       Toast.makeText(this,"Image View",Toast.LENGTH_SHORT).show()
   }
    fun searchClick(view:View){
        Toast.makeText(this,"Search View",Toast.LENGTH_SHORT).show()
    }
    fun ratingClick(view:View){
        Toast.makeText(this,"Rating Bar",Toast.LENGTH_SHORT).show()
    }

    fun calenderClick(view:View){
        Toast.makeText(this,"Calender View",Toast.LENGTH_SHORT).show()
    }

    fun progressClick(view:View){
        Toast.makeText(this,"Progress View",Toast.LENGTH_SHORT).show()
    }






}