package com.example.kts.view.canvas.paint.aview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.kts.utils.px

/**
 * @author 53288
 * @description 钟表
 * @date 2021/11/20
 */
class MyClockView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    val TAG = "WatchClockView"
    var mRadius = 0f    //半径
    var mPadding = 5f.px

    val mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        this.strokeWidth = mPadding
        this.style = Paint.Style.STROKE
        this.isDither = true
        this.color = Color.WHITE
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mRadius = (w - mPadding) / 2f
        Log.d(TAG, "w = $w , h = $h , oldw1 =$oldh, oldh1 = $oldh")
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        paintCircle(canvas)
        paintScale(canvas)
    }

    private fun paintScale(canvas: Canvas) {
        
    }

    private fun paintCircle(canvas: Canvas) {
        canvas.drawCircle(width / 2f, width / 2f, mRadius, mPaint)
    }
}