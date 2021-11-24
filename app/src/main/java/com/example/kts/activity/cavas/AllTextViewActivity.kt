package com.example.kts.activity.cavas

import android.content.Intent
import com.example.kts.R
import com.example.kts.activity.cavas.text.BgTextActivity
import com.example.kts.activity.cavas.text.StaticLayoutActivity
import com.example.kts.base.BaseActivity
import com.example.kts.databinding.ActAllTextBinding


/**
 * @author 53288
 * @description 所有绘制text的总activity
 * @date 2021/11/22
 */
class AllTextViewActivity : BaseActivity<ActAllTextBinding>() {
    override fun initView() {
        mBind.btCommit1.setOnClickListener {

        }
        mBind.btCommit2.setOnClickListener {
            startActivity(Intent(this, StaticLayoutActivity::class.java))
        }
        mBind.btCommit3.setOnClickListener {
            startActivity(Intent(this, TextViewActivity::class.java))
        }

        mBind.btCommit4.setOnClickListener {
            startActivity(Intent(this, ZidingyiTextActivity::class.java))
        }
        mBind.btCommit5.setOnClickListener {
            startActivity(Intent(this, BgTextActivity::class.java))
        }
    }

    override fun getLayout(): Int = R.layout.act_all_text
}