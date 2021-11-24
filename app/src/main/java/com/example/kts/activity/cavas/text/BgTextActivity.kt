package com.example.kts.activity.cavas.text

import android.widget.Toast
import com.example.kts.R
import com.example.kts.base.BaseActivity
import com.example.kts.databinding.ActBgtextBinding

/**
 * @author 53288
 * @description 流布局和自定义button按钮
 * @date 2021/11/23
 */
class BgTextActivity : BaseActivity<ActBgtextBinding>() {
    override fun initView() {
        mBind.btCommit.setOnClickListener {
            Toast.makeText(this, "ahdahd", Toast.LENGTH_SHORT).show()
        }

        mBind.btCommit.text = "hahahahahahah"
    }

    override fun getLayout(): Int = R.layout.act_bgtext
}