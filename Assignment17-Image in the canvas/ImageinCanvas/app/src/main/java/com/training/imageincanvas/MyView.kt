package com.training.imageincanvas

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi

class MyView:View {
  lateinit  var bmap:Bitmap
    lateinit var srcRect:Rect
    lateinit var destRect:Rect

fun init(attr:AttributeSet){
    bmap= BitmapFactory.decodeResource(resources,R.drawable.image)

}
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        attrs?.let { init(it) }
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        srcRect=Rect(0, 0,bmap.width,bmap.height)
        destRect=Rect(0,0,this.width,this.height)
        canvas!!.drawBitmap(bmap,srcRect,destRect,null)



    }
}
/*
package com.training.imageincanvas

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import com.training.imageincanvas.R


class CustomViewImage : View {
    private var imageBitMap: Bitmap? = null
    var srcRect: Rect? = null
    var dstRect: Rect? = null
    var bitmapWidth = 0
    var bitmapHeight = 0

    constructor(context: Context?) : super(context) {
        init(null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(attrs)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(attrs)
    }

    fun init(set: AttributeSet?) {
        imageBitMap = BitmapFactory.decodeResource(resources, R.drawable.image)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        bitmapWidth = imageBitMap!!.width
        bitmapHeight = imageBitMap!!.height
        srcRect = Rect(0, 0, bitmapWidth, bitmapHeight) //size of bitmap
        dstRect = Rect(0, 0, width, height) //size of the custom view
        canvas.drawBitmap(imageBitMap!!, srcRect, dstRect!!, null) //scale bitmap from src to dst
    }
}*/