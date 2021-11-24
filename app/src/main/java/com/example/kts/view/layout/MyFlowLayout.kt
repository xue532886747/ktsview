package com.example.kts.view.layout

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import androidx.core.view.children
import com.example.kts.R

/**
 * @author 53288
 * @description
 * @date 2021/11/23
 */
class MyFlowLayout(context: Context, attributeSet: AttributeSet) :
    ViewGroup(context, attributeSet) {
    var mWidth = 0f     //总宽度
    var mHeight = 0f    //总高度
    val TAG = "MyFlowLayout1"
    val HORIZONTAL = 0
    val VERTICAL = 1
    var myOrientation = HORIZONTAL

    init {
        val ta =
            context.obtainStyledAttributes(attributeSet, R.styleable.MyFlowLayout)
        myOrientation = ta.getInt(R.styleable.MyFlowLayout_myOrientation, myOrientation)
        ta.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        mWidth = 0f
        mHeight = 0f
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val childCount = childCount
        for (i in 0 until childCount) {
            val view = getChildAt(i)
            measureChild(view, widthSize, heightSize)
            //获得子控件的宽度与高度
            val measuredHeight = view.measuredHeight
            val measuredWidth = view.measuredWidth
            mWidth += measuredWidth
            mHeight += measuredHeight
        }
        when (widthMode) {
            MeasureSpec.EXACTLY, MeasureSpec.UNSPECIFIED -> {
                mWidth = widthSize.toFloat()
            }
            else -> {
                if (mWidth > widthSize.toFloat()) {
                    mWidth = widthSize.toFloat()
                }
            }
        }
        when (heightMode) {
            MeasureSpec.EXACTLY, MeasureSpec.UNSPECIFIED -> {
                mHeight = heightSize.toFloat()
            }
            else -> {
                if (mHeight > heightSize.toFloat()) {
                    mHeight = heightSize.toFloat()
                }
            }
        }
        setMeasuredDimension(mWidth.toInt(), mHeight.toInt())
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
//        Log.d(
//            TAG, "onSizeChanged mWidth= $mWidth , mHeight = $mHeight"
//        )
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var top = 0f
        var start = 0f
        for (i in 0 until 2) {
            val childAt = getChildAt(i)
            val childWidth = childAt.measuredWidth
            val childHeight = childAt.measuredHeight
            childAt.layout(
                start.toInt(),
                top.toInt(),
                (start + childWidth).toInt(),
                (childHeight).toInt()
            )
            start += childWidth
            if (start > mWidth) {
                top += childHeight
                start = 0f
            }
            Log.d(
                TAG,
                "onLayout top = $top , start = $start , childWidth= $childWidth , childHeight = $childHeight"
            )
        }
    }
}