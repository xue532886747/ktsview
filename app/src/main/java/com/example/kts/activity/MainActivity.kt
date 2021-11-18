package com.example.kts.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import com.example.kts.R
import com.example.kts.activity.animations.AnimationActivity
import com.example.kts.activity.cavas.CavansActivity
import com.example.kts.activity.touch.CeShiTouchActivity
import com.example.kts.activity.viewpager.MyViewPagerActivity
import com.example.kts.base.BaseActivity
import com.example.kts.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getLayout(): Int = R.layout.activity_main

    override fun initView() {
        mBind.btCavans.setOnClickListener {
            startActivity(Intent(this, CavansActivity::class.java))
        }
        mBind.btAnimation.setOnClickListener {
            startActivity(Intent(this, AnimationActivity::class.java))
        }
        mBind.btTouch.setOnClickListener {
            startActivity(Intent(this, CeShiTouchActivity::class.java))
        }
        mBind.btViewpager.setOnClickListener {
            startActivity(Intent(this, MyViewPagerActivity::class.java))
        }
    }


}