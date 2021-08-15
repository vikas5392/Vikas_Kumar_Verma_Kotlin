package com.training.customalert

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
  fun getAlert(view: View){
var builder:AlertDialog.Builder= AlertDialog.Builder(this)
      val alertView:View =layoutInflater.inflate(R.layout.alert_layout,null)
      builder.setView(alertView)
      builder.setPositiveButton("OK",{ dialogInterface: DialogInterface, i: Int ->finish() })
      builder.create()
      builder.show()
  }
}