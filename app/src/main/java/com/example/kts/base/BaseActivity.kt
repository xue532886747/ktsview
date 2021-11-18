package com.example.kts.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @author 53288
 * @description
 * @date 2021/11/16
 */
abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity() {

    lateinit var mBind: DB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBind = DataBindingUtil.setContentView(this, getLayout())
        initView()
    }

    abstract fun initView()

    abstract fun getLayout(): Int
}