package com.example.kts.view.mytextview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.kts.R
import com.example.kts.utils.px

/**
 * @author 53288
 * @description
 * @date 2021/11/22
 */
class NewTextView(context: Context, attributeSet: AttributeSet) :
    View(context, attributeSet) {

    var newTextSize = 22f.px
    var content: String? = null
    val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        val ta = context.obtainStyledAttributes(attributeSet, R.styleable.NewTextView)
        newTextSize = ta.getDimension(R.styleable.NewTextView_new_text_size, newTextSize)
        content = ta.getString(R.styleable.NewTextView_new_text_content)
        ta.recycle()
        inits()
    }

    private fun inits() {
        paint.apply {
            style = Paint.Style.FILL
            textSize = newTextSize;
            color = Color.BLACK
            textAlign = Paint.Align.CENTER
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val fontMetrics = paint.fontMetrics
        paint.getFontMetrics(fontMetrics)
        val baseline =
            height / 2 + (fontMetrics.bottom - fontMetrics.ascent) / 2f - fontMetrics.bottom
        canvas.drawText(content!!, width / 2f, height / 2f, paint)
    }
}