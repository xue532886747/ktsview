package com.example.kts.view.canvas.paint.aview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import android.view.View
import com.example.kts.R
import com.example.kts.utils.px

/**
 * @author 53288
 * @description 绘制一些基本的图形
 * @date 2021/11/16
 */
class DrawGraphicalView(context: Context, attributeSet: AttributeSet) :
    View(context, attributeSet) {

    val mWidth = 10f.px
    val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        this.style = Paint.Style.STROKE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.color = context.getColor(R.color.teal_200)
        }
        this.strokeWidth = mWidth
    }


    override fun onDraw(canvas: Canvas) {
//        canvasLine(canvas)
        canvasRectF(canvas)
    }

    private fun canvasRectF(canvas: Canvas) {
        val rectF = RectF(mWidth / 2f, mWidth / 2f, 150f.px, 150f.px)
        canvas.drawRect(rectF, paint)
    }

    //绘制直线
    private fun canvasLine(canvas: Canvas) {
        canvas.drawLine(0f, 0f, 200f, 200f, paint)
    }
}