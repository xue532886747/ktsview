package com.example.kts.view.text

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.kts.R
import com.example.kts.utils.px

/**
 * @author 53288
 * @description
 * @date 2021/11/23
 */
class MyButtonView(context: Context, attr: AttributeSet) : View(context, attr) {
    val TAG = "MyButtonView1"
    var mTextSize = 14f.px
    var content: String? = null
    var font = Paint.FontMetrics()
    var heightSide = 50f.px               // 长
    var widthSide = heightSide + heightSide / 2f //宽
    val rectF = Rect()
    val rectRect = RectF()
    val mRadius = 10f       //方形背景的圆角
    val edge = 10f          //底层上下左右的留白
    var bgColor = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        context.getColor(R.color.purple_500)
    } else {
        resources.getColor(R.color.purple_500)
    }

    init {
        val ta = context.obtainStyledAttributes(attr, R.styleable.MyButtonView)
        mTextSize = ta.getDimension(R.styleable.MyButtonView_new_text_size, mTextSize)
        content = ta.getString(R.styleable.MyButtonView_new_text_content)
        bgColor = ta.getColor(R.styleable.MyButtonView_new_bg_color, bgColor)
        ta.recycle()
    }

    val mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = mTextSize
        style = Paint.Style.FILL
        color = Color.WHITE
        textAlign = Paint.Align.CENTER
    }

    val mBgPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = bgColor
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        content?.length.let { it?.let { it1 -> mPaint.getTextBounds(content, 0, it1, rectF) } }
        rectRect.left = edge + mRadius / 2f
        rectRect.top = edge + mRadius / 2f
        rectRect.right = widthSide - (edge + mRadius / 2f)
        rectRect.bottom = heightSide - (edge + mRadius / 2f)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        when (widthMode) {
            MeasureSpec.AT_MOST -> {
                if (!content.isNullOrEmpty()) {
                    mPaint.getTextBounds(content, 0, content!!.length, rectF)
                    widthSide = rectF.left + rectF.right + (edge + mRadius) * 2
                }
            }
            MeasureSpec.EXACTLY -> {
                widthSide = widthSize.toFloat() + (edge + mRadius) * 2
            }
            MeasureSpec.UNSPECIFIED -> {

            }
        }
        when (heightMode) {
            MeasureSpec.AT_MOST -> {
                if (!content.isNullOrEmpty()) {
                    heightSide = (rectF.bottom - rectF.top) + (edge + mRadius) * 2 + 20f
                }
            }
            MeasureSpec.EXACTLY -> {
                heightSide = heightSize.toFloat() + (edge + mRadius) * 2
            }
            MeasureSpec.UNSPECIFIED -> {
            }
        }
        setMeasuredDimension(widthSide.toInt(), heightSide.toInt())
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvasRound(canvas)
        canvasText(canvas)
    }

    private fun canvasRound(canvas: Canvas) {
        Log.d(TAG, "width = $width , heightSize = $height")
//        Log.d(
//            TAG,
//            "top = ${rectRect.top} , bottom = ${rectRect.bottom} , left = ${rectRect.left} , right = ${rectRect.right}  "
//        )
        canvas.drawRoundRect(rectRect, mRadius, mRadius, mBgPaint)
    }

    private fun canvasText(canvas: Canvas) {
        mPaint.getFontMetrics(font)
        val baseline =
            height / 2 + (font.bottom - font.ascent) / 2f - font.bottom
        content?.let {
            content?.length?.let { it1 ->
                canvas.drawText(
                    it, 0,
                    it1, width / 2f, baseline, mPaint
                )
            }
        }
    }
}