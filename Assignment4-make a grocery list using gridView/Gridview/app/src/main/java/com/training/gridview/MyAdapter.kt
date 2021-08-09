package com.training.gridview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import java.util.zip.Inflater

class MyAdapter(var list:ArrayList<Model>) : BaseAdapter() {
    //lateinit var list: ArrayList<Model>


    override fun getCount(): Int {

        return list.size
    }

    override fun getItem(position: Int): Any {

        return list.get(position)
    }

    override fun getItemId(position: Int): Long {

        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflater: LayoutInflater= LayoutInflater.from(parent?.context)
       val  singleItemView:View=inflater.inflate(R.layout.single_item,parent,false)
       var nameText: TextView =singleItemView.findViewById(R.id.textView3)
        var costText:TextView=singleItemView.findViewById(R.id.textView4)
        nameText.setText(list.get(position).product)
        costText.setText(list.get(position).price)
        return singleItemView

    }
}