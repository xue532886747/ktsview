package com.example.kts.activity.cavas

import com.example.kts.R
import com.example.kts.base.BaseActivity
import com.example.kts.databinding.ActZidingyiBinding

/**
 * @author 53288
 * @description
 * @date 2021/11/22
 */
class ZidingyiTextActivity : BaseActivity<ActZidingyiBinding>() {
    val name =
        "楼主写复杂了吧，一个属性动画改变高度不就行了。我刚才试了下，五分钟就实现了动画。没有考虑太多，换行主要是需求要求这么省略号和展开要在最后一行结尾，还是你有更好的方法？" +
                "楼主写复杂了吧，一个属性动画改变高度不就行了。我刚才试了下，五分钟就实现了动画。没有考虑太多，换行主要是需求要求这么省略号和展开要在最后一行结尾，还是你有更好的方法？" +
                "楼主写复杂了吧，一个属性动画改变高度不就行了。我刚才试了下，五分钟就实现了动画。没有考虑太多，换行主要是需求要求这么省略号和展开要在最后一行结尾，还是你有更好的方法？"

    override fun initView() {


    }

    override fun getLayout(): Int = R.layout.act_zidingyi
}