package com.training.sticker
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class StickerView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    lateinit var rectSrc:Rect
    lateinit var rectDst:Rect
    var b_map:Bitmap=BitmapFactory.decodeResource(resources,R.drawable.like_image)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        rectSrc=Rect(0, 0,b_map.width,b_map.height)
        rectDst=Rect(0,0,this.width,this.height)
        canvas!!.drawBitmap(b_map,rectSrc,rectDst,null)
    }
}