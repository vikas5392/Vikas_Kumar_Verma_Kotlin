package com.training.sharedpreference

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var inputText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputText = findViewById(R.id.editTextTextPersonName)
    }


    fun goSave(view: View) {
        var noteMsg: String? = inputText.text.toString()
        val sharedPref: SharedPreferences = getSharedPreferences("Notes", MODE_PRIVATE)
        var editShared: SharedPreferences.Editor = sharedPref.edit()
        if (noteMsg != null) {
            editShared.putString("note1", noteMsg)
            editShared.apply()
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show()
        } else
            Toast.makeText(this, "Note empty", Toast.LENGTH_SHORT).show()
    }
    fun goRead(view: View) {
        val getPref: SharedPreferences = getSharedPreferences("Notes", MODE_PRIVATE)
        var txt: String? = getPref.getString("note1", "save note")

       getPref.all
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("firstText", txt)
        startActivity(intent)

    }
}