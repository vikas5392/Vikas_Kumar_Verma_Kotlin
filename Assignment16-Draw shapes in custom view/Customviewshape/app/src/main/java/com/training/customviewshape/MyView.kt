package com.training.customview.Views

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi

class CustomView : View {


    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)
    var m_paint=Paint()


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        m_paint.color=Color.RED
        canvas.drawRect(10f,10f,180f,180f,m_paint)
        m_paint.color=Color.GREEN
        canvas.drawCircle(300f,100f,100f,m_paint)
        m_paint.color=Color.BLUE
        canvas.drawLine(420f,100f,1000f,100f,m_paint)
        m_paint.color=Color.CYAN
       var  m_path=Path()
        m_path.moveTo(190f,650f)
        m_path.lineTo(100f,90f)
        m_path.lineTo(180f,90f)
        m_path.lineTo(190f,250f)
        m_path.close()
        canvas.drawPath(m_path,m_paint)
    }
}