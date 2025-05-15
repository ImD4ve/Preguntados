package com.example.preguntados
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

class WheelView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rectF = RectF()
    private val categories = listOf("Arte", "Química", "Ciencia", "Historia")
    private val colors = listOf(
        Color.parseColor("#FF5722"),  // Naranja arte
        Color.parseColor("#4CAF50"),  // Verde química
        Color.parseColor("#2196F3"),  // Azul ciencia
        Color.parseColor("#9C27B0")   // Morado historia
    )
    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        textSize = 40f
        textAlign = Paint.Align.CENTER
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val diameter = minOf(width, height) * 0.9f
        rectF.set(
            (width - diameter) / 2,
            (height - diameter) / 2,
            (width + diameter) / 2,
            (height + diameter) / 2
        )

        val sweepAngle = 360f / categories.size

        categories.forEachIndexed { index, _ ->
            paint.color = colors[index]
            canvas.drawArc(rectF, index * sweepAngle, sweepAngle, true, paint)

            // Dibujar texto en cada segmento
            val angle = Math.toRadians((index * sweepAngle + sweepAngle / 2).toDouble())
            val x = (width / 2 + (diameter / 3 * cos(angle))).toFloat()
            val y = (height / 2 + (diameter / 3 * sin(angle))).toFloat()

            canvas.save()
            canvas.rotate(index * sweepAngle + sweepAngle / 2, x, y)
            canvas.drawText(categories[index], x, y, textPaint)
            canvas.restore()
        }
    }
}