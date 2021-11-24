package com.example.kts.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.kts.R
import com.example.kts.activity.animations.AnimationActivity
import com.example.kts.activity.cavas.AllTextViewActivity
import com.example.kts.activity.cavas.CavansActivity
import com.example.kts.activity.cavas.TextViewActivity
import com.example.kts.activity.touch.CeShiTouchActivity
import com.example.kts.activity.viewpager.MyViewPagerActivity
import com.example.kts.base.BaseActivity
import com.example.kts.databinding.ActivityMainBinding
import com.example.kts.viewmodel.MyViewModel


class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getLayout(): Int = R.layout.activity_main

    lateinit var mViewModel: MyViewModel

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
        mBind.btTextview.setOnClickListener {
            startActivity(Intent(this, AllTextViewActivity::class.java))
        }
        mViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MyViewModel::class.java)


    }

    override fun onDestroy() {
        super.onDestroy()

    }
}