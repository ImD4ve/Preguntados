package com.example.preguntados
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class PointerView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        style = Paint.Style.FILL
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val path = Path().apply {
            moveTo(width / 2f, 0f)
            lineTo(0f, height.toFloat())
            lineTo(width.toFloat(), height.toFloat())
            close()
        }
        canvas.drawPath(path, paint)
    }
}