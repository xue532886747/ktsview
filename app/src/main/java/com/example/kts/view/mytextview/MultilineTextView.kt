package com.example.kts.view.mytextview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.example.kts.utils.px

/**
 * @author 53288
 * @description
 * @date 2021/11/20
 */
class MultilineTextView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    val text =
        "楼主写复杂了吧，一个属性动画改变高度不就行了。我刚才试了下，五分钟就实现了动画。没有考虑太多，换行主要是需求要求这么省略号和展开要在最后一行结尾，还是你有更好的方法？" +
                "楼主写复杂了吧，一个属性动画改变高度不就行了。我刚才试了下，五分钟就实现了动画。没有考虑太多，换行主要是需求要求这么省略号和展开要在最后一行结尾，还是你有更好的方法？" +
                "楼主写复杂了吧，一个属性动画改变高度不就行了。我刚才试了下，五分钟就实现了动画。没有考虑太多，换行主要是需求要求这么省略号和展开要在最后一行结尾，还是你有更好的方法？"

    val mTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).also {
        it.strokeWidth = 10f.px
        it.style = Paint.Style.FILL
        it.color = Color.BLACK
        it.textSize = 21f.px
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        val staticLayout =
//            StaticLayout(text, mTextPaint, width, Layout.Alignment.ALIGN_NORMAL, 1f, 0f, false)
//        staticLayout.draw(canvas)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val build = StaticLayout.Builder.obtain(text, 0, text.length, mTextPaint, width).build()
            build.draw(canvas)
        }
    }
}