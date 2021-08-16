package com.training

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE=1
  lateinit var  iv:ImageView
  lateinit var  button:Button
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iv=findViewById(R.id.imageView)
        button=findViewById(R.id.button)
      if(!cameraAvailable())
        button.isEnabled=false
    }
fun cameraAvailable():Boolean{
return packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)
}
    fun getImage(view: View){
      val  i= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(i,REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==REQUEST_CODE&&resultCode== RESULT_OK)
        {
         var imageExtra: Bundle? = data?.extras
            var photo:Bitmap= imageExtra?.get("data") as Bitmap
            iv.setImageBitmap(photo)

        }
    }
}