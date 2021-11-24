package com.example.kts.activity.cavas

import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kts.R
import com.example.kts.base.BaseActivity
import com.example.kts.databinding.ActTextviewBinding
import kotlin.math.log

/**
 * @author 53288
 * @description 展开 折叠 测试两个方法
 * @date 2021/11/20
 */
class TextViewActivity : BaseActivity<ActTextviewBinding>() {
    var span = false
    var lineCount = 0
    val name =
        "楼主写复杂了吧，一个属性动画改变高度不就行了。我刚才试了下，五分钟就实现了动画。没有考虑太多，换行主要是需求要求这么省略号和展开要在最后一行结尾，还是你有更好的方法？" +
                "楼主写复杂了吧，一个属性动画改变高度不就行了。我刚才试了下，五分钟就实现了动画。没有考虑太多，换行主要是需求要求这么省略号和展开要在最后一行结尾，还是你有更好的方法？" +
                "楼主写复杂了吧，一个属性动画改变高度不就行了。我刚才试了下，五分钟就实现了动画。没有考虑太多，换行主要是需求要求这么省略号和展开要在最后一行结尾，还是你有更好的方法？"
    val TAG = "TextViewActivity1"
    override fun initView() {
        mBind.tvName.text = name
        mBind.btCommit.setOnClickListener {
            span = !span
            if (span) {
                mBind.btCommit.text = "展开"
            } else {
                mBind.btCommit.text = "关闭"
            }
            mBind.tvName.post {
                lineCount = mBind.tvName.lineCount
                Log.d(TAG, "lineCount = $lineCount")
                if (lineCount > 10) {
                    mBind.tvName.maxLines = 10
                    mBind.tvName.ellipsize = TextUtils.TruncateAt.END
                } else {
                    mBind.tvName.maxLines = 12
                    mBind.tvName.ellipsize = TextUtils.TruncateAt.START
                }
                mBind.tvName.postInvalidate()
            }
        }
    }

    override fun getLayout(): Int = R.layout.act_textview

}