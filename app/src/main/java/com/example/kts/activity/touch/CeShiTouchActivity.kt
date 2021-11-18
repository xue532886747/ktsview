package com.example.kts.activity.touch

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kts.Constant
import com.example.kts.R
import com.example.kts.base.BaseActivity
import com.example.kts.databinding.ActCeshitouchBinding

/**
 * @author 53288
 * @description
 * @date 2021/11/16
 */
class CeShiTouchActivity : BaseActivity<ActCeshitouchBinding>() {

    override fun initView() {
        mBind.btButton.setOnClickListener {
            Toast.makeText(this, "AAAaAa", Toast.LENGTH_SHORT).show()
        }
        mBind.btButton.setOnTouchListener { v, event ->

            true
        }

    }

    override fun getLayout(): Int = R.layout.act_ceshitouch

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(
            Constant.MyViewStr,
            "class:${javaClass.name} , dispatchTouchEvent : event.action${ev?.action}"
        )
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(
            Constant.MyViewStr,
            "class:${javaClass.name} , dispatchTouchEvent : event.action${event?.action}"
        )
        return super.onTouchEvent(event)
    }

}