package com.example.kts.activity.cavas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kts.R
import com.example.kts.base.BaseActivity
import com.example.kts.databinding.ActCavansBinding

/**
 * @author 53288
 * @description 绘制中标
 * @date 2021/11/15
 */
class CavansActivity : BaseActivity<ActCavansBinding>() {

    override fun initView() {
        mBind.btBlock.setOnClickListener {
            startActivity(Intent(this, ClockActivity::class.java))
        }
    }

    override fun getLayout(): Int {
        return R.layout.act_cavans
    }

}