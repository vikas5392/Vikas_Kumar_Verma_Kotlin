package com.training.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView

class MainActivity : AppCompatActivity() {
    lateinit var gv:GridView
    lateinit var finalList:ArrayList<Model>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gv=findViewById(R.id.gridView)
        finalList=ArrayList<Model>()

        finalList.add(Model("PRODUCT","PRICE"))
        finalList.add(Model("rice","Rs 30/kg"))
        finalList.add(Model("pulses","Rs 20/kg"))
        finalList.add(Model("oil","Rs 30/l"))
        finalList.add(Model("Soap","Rs 60/doz"))
     val adapter:MyAdapter=MyAdapter(finalList)
        gv.setAdapter(adapter)

    }
}