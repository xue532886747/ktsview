package com.example.kts.view.ceshitouch

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.LinearLayout
import com.example.kts.Constant

/**
 * @author 53288
 * @description
 * @date 2021/11/16
 */
class MyLinearLayout(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet) {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(
            Constant.MyViewStr,
            "class:${javaClass.name} , dispatchTouchEvent : event.action${ev?.action}"
        )
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(
            Constant.MyViewStr,
            "class:${javaClass.name} , onInterceptTouchEvent : event.action${ev?.action}"
        )
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(
            Constant.MyViewStr,
            "class:${javaClass.name} , onTouchEvent : event.action${event?.action}"
        )
        return super.onTouchEvent(event)
    }
}