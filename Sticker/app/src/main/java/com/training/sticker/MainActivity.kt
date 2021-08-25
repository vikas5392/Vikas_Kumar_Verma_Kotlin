package com.training.sticker

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.widget.ImageView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    lateinit var getImageUri: ActivityResultLauncher<String>
    lateinit var m_image: ImageView
    lateinit var sticker_view: StickerView
    lateinit var m_scaleGestureDetector: ScaleGestureDetector
    var scaleFactor = 1.0F
    var status = false
    var x_down = 0F
    var y_down = 0F
    var x_moved_to = 0F
    var y_moved_to = 0F
    var dist_moved_x = 0F
    var dist_moved_y = 0F

    companion object {
        val READ_PERMISSION_CODE = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        m_image = findViewById(R.id.imageView)
        sticker_view = findViewById(R.id.stickerView)
        m_scaleGestureDetector = ScaleGestureDetector(this, MyScaleListner())

        getImageUri = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback { uri -> m_image.setImageURI(uri) })

        // on touchlistner to sticker_view
        sticker_view.setOnTouchListener(object : View.OnTouchListener {

            @SuppressLint("ClickableViewAccessibility")
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.actionMasked) {
                    MotionEvent.ACTION_DOWN -> {
                        x_down = event.x
                        y_down = event.y
                        status = true
                    }
                    MotionEvent.ACTION_MOVE -> {
                        //Moved to this point
                        x_moved_to = event.x
                        y_moved_to = event.y

                        //distance between initial point and moved point-this gives the dis moved by the finger
                        dist_moved_x = x_moved_to - x_down
                        dist_moved_y = y_moved_to - y_down

                        //now we shift the view same distance as mived by finger, hence we give the new coordinate of teh view
                        sticker_view.x = sticker_view.x + dist_moved_x
                        sticker_view.y = sticker_view.y + dist_moved_y
                        status = true
                    }
                    else -> status = false
                }
                return status
            }


        })

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return m_scaleGestureDetector.onTouchEvent(event)
    }

    // To implement zoom
    inner class MyScaleListner : ScaleGestureDetector.OnScaleGestureListener {
        override fun onScale(detector: ScaleGestureDetector?): Boolean {
            scaleFactor *= detector!!.scaleFactor
            sticker_view.scaleX = scaleFactor
            sticker_view.scaleY = scaleFactor
            return true
        }

        override fun onScaleBegin(detector: ScaleGestureDetector?): Boolean {
            TODO("Not yet implemented")
        }

        override fun onScaleEnd(detector: ScaleGestureDetector?) {
            TODO("Not yet implemented")
        }

    }


    fun getPhoto(view: View) {
        if ((ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )) == (PackageManager.PERMISSION_GRANTED)
        ) {
            performActivity()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                READ_PERMISSION_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == READ_PERMISSION_CODE) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                performActivity()
            }
        }
    }

    fun performActivity() {
        getImageUri.launch("image/*")
    }
}