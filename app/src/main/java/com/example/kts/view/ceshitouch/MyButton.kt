package com.example.kts.view.ceshitouch

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import com.example.kts.Constant

/**
 * @author 53288
 * @description
 * @date 2021/11/16
 */
class MyButton(context: Context, attributeSet: AttributeSet) :  AppCompatButton(context, attributeSet) {

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(
            Constant.MyViewStr,
            "class:${javaClass.name} , onTouchEvent : event.action${event?.action}"
        )
        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        Log.d(
            Constant.MyViewStr,
            "class:${javaClass.name} , dispatchTouchEvent : event.action${event?.action}"
        )
        return super.dispatchTouchEvent(event)
    }

}