package com.training.imageintent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var iv:ImageView
   val getAction=registerForActivityResult(ActivityResultContracts.GetContent(),
    ActivityResultCallback { uri->iv.setImageURI(uri) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iv=findViewById(R.id.imageView)
    }
    fun getImage(view: View){

        getAction.launch("image/*")
    }

}