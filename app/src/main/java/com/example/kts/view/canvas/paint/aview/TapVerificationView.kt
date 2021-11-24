package com.example.kts.view.canvas.paint.aview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.kts.R
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author 53288
 * @description
 * @date 2021/11/22
 */
class TapVerificationView(context: Context, attr: AttributeSet) : View(context, attr) {

    //画布的宽高
    var width = 0f
    var height = 0f

    var oldBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.mipmap.xjpzx)

    //根据准备的图片重新调整尺寸后的背景图
    lateinit var bgBitmap: Bitmap
    val bgPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        isFilterBitmap = true
    }
    var bgRectF = RectF()

    //验证码文字画笔
    var textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        isFakeBoldText = true
        color = Color.parseColor("#AA000000")
        setShadowLayer(3f, 2f, 2f, Color.RED)
        xfermode = PorterDuffXfermode(PorterDuff.Mode.LIGHTEN)
    }
    var selectPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.WHITE
    }
    var selectTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {

    }
    var regions = ArrayList<Region>()

    var random: Random = Random()
    var fonts = ""
    var checkCode = 0

    var tapPoints = ArrayList<Point>()
    var tapIndex = ArrayList<Int>()
    var textPoints = ArrayList<Point>()
    var degrees = ArrayList<Int>()
    var isInit = true

    init {
        var temp = fonts.length - 1
        while (temp > -1) {
            checkCode += temp * Math.pow(10.toDouble(), temp.toDouble()).toInt()
            temp--;
        }
    }
}