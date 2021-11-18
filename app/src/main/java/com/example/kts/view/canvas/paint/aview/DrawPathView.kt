package com.example.kts.view.canvas.paint.aview

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.view.View
import com.example.kts.R
import com.example.kts.utils.px

/**
 * @author 53288
 * @description
 * @date 2021/11/17
 */
class DrawPathView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    var mPath: Path = Path()

    init {
        mPaint.style = Paint.Style.STROKE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mPaint.color = context.getColor(R.color.purple_200)
        }
        mPaint.strokeWidth = 10f.px
    }

    override fun onDraw(canvas: Canvas?) {
        mPath.moveTo(10f, 10f)
        mPath.lineTo(10f,100f)
        canvas?.drawPath(mPath, mPaint)
    }
}