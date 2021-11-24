package com.example.kts.view.canvas.paint.aview

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.kts.R
import com.example.kts.utils.px
import java.util.*

/**
 * @author 53288
 * @description
 * @date 2021/11/19
 */
class WatchClockView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    val TAG = "WatchClockView"
    var mRadius = 0f        //  外圆半径
    var mPadding = 10f       //  边距
    var mTextSize = 16f.px      //  文字大小
    var mHourPointWidth = 5f.px    //时针宽度
    var mMinutePointWidth = 4f.px  //分针宽度
    var mSecondPointWidth = 3f.px  //秒针宽度
    var mPointRadius = 10f       //指针圆角
    var mPointEndLength = 3f.px     //指针末尾的长度
    var mColorLong = 0      //长线的颜色
    var mColorShort = 0        //短线的颜色
    var mHourPointColor = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        context.getColor(R.color.black1)
    } else {
        TODO("VERSION.SDK_INT < M")
    }     //时针的颜色
    var mMinutePointColor = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        context.getColor(R.color.black)
    } else {
        TODO("VERSION.SDK_INT < M")
    } //分针的颜色
    var mSecondPointColor = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        context.getColor(R.color.red)
    } else {
        TODO("VERSION.SDK_INT < M")
    }
    var mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        this.isDither = true
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.d(TAG, "w = $w , h = $h , oldw1 =$oldh, oldh1 = $oldh")
        mRadius = (w - mPadding) / 2f
        mPointEndLength = mRadius / 6f      //尾部指针默认为半径的六分之一
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        canvas.translate(width / 2f, height / 2f)
        paintCircle(canvas)
        paintScale(canvas)
        paintPointer(canvas)
        postInvalidateDelayed(1000)
//        canvas.restore()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

    }

    //TODO 绘制指针
    private fun paintPointer(canvas: Canvas) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE) //分
        val second = calendar.get(Calendar.SECOND) //秒
        val angleHour = (hour % 12) * 360 / 12f      //指针转过的角度
        val angelMinute = minute * 360 / 60f  //分针走过的角度
        val angleSecond = second * 360 / 60f  //秒针走过的角度
        canvas.translate(width / 2f, height / 2f)
        //绘制时针
        canvas.save()
        canvas.rotate(angleHour)
        val rectFHour =
            RectF(-mHourPointWidth / 2f, -mRadius * 3 / 6f, mHourPointWidth / 2f, mPointEndLength)
        mPaint.color = mHourPointColor
        mPaint.style = Paint.Style.STROKE;
        mPaint.strokeWidth = mHourPointWidth; //设置边界宽度
        canvas.drawRoundRect(rectFHour, mPointRadius, mPointRadius, mPaint); //绘制时针
        canvas.restore()

        canvas.save()
        canvas.rotate(angelMinute)
        val rectFMinute = RectF(
            -mMinutePointWidth / 2,
            -mRadius * 3.5f / 6,
            mMinutePointWidth / 2,
            mPointEndLength
        )
        mPaint.color = mMinutePointColor
        mPaint.strokeWidth = mMinutePointWidth
        canvas.drawRoundRect(rectFMinute, mPointRadius, mPointRadius, mPaint)
        canvas.restore()

        canvas.save()
        canvas.rotate(angleSecond)
        val rectFSecond =
            RectF(-mSecondPointWidth / 2, -mRadius + 50f.px, mSecondPointWidth / 2, mPointEndLength)
        mPaint.color = mSecondPointColor
        mPaint.strokeWidth = mSecondPointWidth
        canvas.drawRoundRect(rectFSecond, mPointRadius, mPointRadius, mPaint)
        canvas.restore()

        //绘制中心小圆
        mPaint.style = Paint.Style.FILL;
        mPaint.color = mSecondPointColor;
        canvas.drawCircle(0f, 0f, mSecondPointWidth * 4, mPaint);

    }

    //TODO 绘制文字
    private fun paintText(canvas: Canvas) {
        canvas.save()
        val lineWidth = 50
        mPaint.textSize = 10f
        for (i in 0..60) {
            var text: String
            if (i % 5 == 0) {
                text = if (i == 0) {
                    "12"
                } else {
                    (i / 5).toString()
                }

            }
        }

        canvas.restore()
    }

    //TODO 刻度
    private fun paintScale(canvas: Canvas) {
        mPaint.strokeWidth = 10f
        var lineWidth = 0
        for (i in 0..60) {
            var text: String
            if (i % 5 == 0) {
                mPaint.strokeWidth = 15f
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mPaint.color = context.getColor(R.color.black)
                }
                lineWidth = 50
                text = if (i == 0) {
                    "12"
                } else {
                    (i / 5).toString()
                }
                mPaint.color = Color.BLACK
                canvas.save()
                mPaint.textSize = mTextSize;
                val textBound = Rect()
                mPaint.getTextBounds(text, 0, text.length, textBound)
                val textHeight = textBound.bottom - textBound.top
                canvas.translate(0f, -mRadius + 15f + lineWidth + textHeight)
                canvas.rotate((-6 * i).toFloat())
                mPaint.style = Paint.Style.FILL
                canvas.drawText(
                    text,
                    -(textBound.right - textBound.left) / 2f,
                    -(textBound.bottom + textBound.top) / 2f,
                    mPaint
                )
                canvas.restore()
            } else {
                mPaint.strokeWidth = 10f
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mPaint.color = context.getColor(R.color.black1)
                }
                lineWidth = 30
            }
            canvas.drawLine(0f, -mRadius + 10f, 0f, -mRadius + 10 + lineWidth, mPaint)
            canvas.rotate(6f)
        }
        canvas.restore()
    }


    //TODO 绘制外圆背景
    private fun paintCircle(canvas: Canvas) {
        mPaint.color = Color.WHITE
        mPaint.style = Paint.Style.FILL
        canvas.drawCircle(0f, 0f, mRadius, mPaint)
    }
}