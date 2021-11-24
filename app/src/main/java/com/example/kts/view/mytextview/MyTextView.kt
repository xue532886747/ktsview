package com.example.kts.view.mytextview

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.kts.utils.px

/**
 * @author 53288
 * @description 文字基线的研究
 * @date 2021/11/19
 */
class MyTextView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    val TAG = "MyTextView1"
    val str = "我爱中国AjJLGWp"
    val rect = Rect()
    val font = Paint.FontMetrics()
    val mTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).also {
        it.density = resources.displayMetrics.density
        it.strokeWidth = 10f.px
        it.style = Paint.Style.FILL
        it.color = Color.BLACK
        it.textSize = 42f.px
        it.textAlign = Paint.Align.CENTER
    }

    val mGaPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 3f.px
        style = Paint.Style.STROKE
        color = Color.RED
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawText(canvas)

    }

    //绘制线段
    private fun canvasLines(canvas: Canvas, baseline: Float) {
        drawLiness(canvas, baseline)
        mGaPaint.color = Color.BLUE
        drawLiness(canvas, baseline + font.bottom)
        mGaPaint.color = Color.GREEN
        drawLiness(canvas, baseline + font.top)
        mGaPaint.color = Color.GRAY
        drawLiness(canvas, baseline + font.ascent)
        mGaPaint.color = Color.YELLOW
        drawLiness(canvas, baseline + font.descent)
    }

    private fun drawLiness(canvas: Canvas, baseline: Float) {
        canvas.drawLine(
            0f,
            baseline,
            width.toFloat(),
            baseline,
            mGaPaint
        )
    }

    private fun drawText(canvas: Canvas) {
        mTextPaint.getTextBounds(str, 0, str.length, rect)
        mTextPaint.getFontMetrics(font)
        Log.d(
            TAG,
            "top = ${font.top} , ascent = ${font.ascent} , descent = ${font.descent} , bottom = ${font.bottom}"
        )
        val baseline = height / 2 + (font.bottom - font.ascent) / 2f - font.bottom
        canvas.drawText(str, width / 2f, baseline, mTextPaint)
        canvasLines(canvas, baseline)
    }


    private fun drawPaint(canvas: Canvas) {
        val rect = RectF(100f, height / 2f - 300, width - 100f, height / 2f + 300)
        canvas.drawRect(rect, mGaPaint)
    }
}