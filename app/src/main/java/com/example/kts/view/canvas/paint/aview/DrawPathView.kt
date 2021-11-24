package com.example.kts.view.canvas.paint.aview

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import com.example.kts.R

/**
 * @author 53288
 * @description
 * @date 2021/11/17
 */
class DrawPathView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    var mPath: Path = Path()
    val mTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        this.style = Paint.Style.STROKE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.color = context.getColor(R.color.teal_200)
        }
        this.textSize = 35f
    }

    init {
        mPaint.style = Paint.Style.STROKE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mPaint.color = context.getColor(R.color.purple_200)
        }
        mPaint.strokeWidth = 10f
    }

    override fun onDraw(canvas: Canvas?) {
        //initPathTriangle(canvas)
        //initPathRect(canvas)
        // initPathRectAndText(canvas)
        //initPathCircleRect(canvas)
        //initPathCircle(canvas);
        initPathOval(canvas)
    }


    //TODO 椭圆
    private fun initPathOval(canvas: Canvas?) {
        val rect = RectF(50f, 50f, 240f, 200f)
        mPath.addOval(rect, Path.Direction.CCW)
        canvas?.drawPath(mPath, mPaint)
    }

    //TODO 圆心
    private fun initPathCircle(canvas: Canvas?) {
        mPath.addCircle(width / 2f, height / 2f, 100f, Path.Direction.CCW)
        canvas?.drawPath(mPath, mPaint)

    }

    //TODO 圆角矩形路径
    private fun initPathCircleRect(canvas: Canvas?) {
        val rect = RectF(50f, 50f, 240f, 200f)
        mPath.addRoundRect(rect, 10f, 15f, Path.Direction.CCW)
        canvas?.drawPath(mPath, mPaint)
    }

    //TODO 绘制路径和文字
    private fun initPathRectAndText(canvas: Canvas?) {
        val rect = RectF(50f, 50f, 480f, 200f)
        mPath.addRect(rect, Path.Direction.CCW)
        canvas?.drawPath(mPath, mPaint)
        val str = "习近平新时代中国特色社会主义思想"
        canvas?.drawTextOnPath(str, mPath, 0f, str.length.toFloat(), mTextPaint)
    }


    //TODO 绘制矩形
    private fun initPathRect(canvas: Canvas?) {
        val rect = RectF(50f, 50f, 480f, 200f)
        mPath.addRect(rect, Path.Direction.CCW)
        canvas?.drawPath(mPath, mPaint)
    }

    //TODO 绘制三角形
    private fun initPathTriangle(canvas: Canvas?) {
        mPath.moveTo(10f, 10f)
        mPath.lineTo(10f, 100f)
        mPath.lineTo(300f, 100f)
        mPath.lineTo(500f, 100f)
        mPath.close()
        canvas?.drawPath(mPath, mPaint)
    }
}