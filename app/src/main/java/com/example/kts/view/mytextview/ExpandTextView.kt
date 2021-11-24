package com.example.kts.view.mytextview

import android.content.Context
import android.graphics.Paint
import android.text.DynamicLayout
import android.text.TextPaint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.ctetin.expandabletextviewlibrary.ExpandableTextView

/**
 * @author 53288
 * @description
 * @date 2021/11/22
 */
class ExpandTextView(context: Context, attr: AttributeSet) : AppCompatTextView(context, attr) {

    val DEF_NAX_LINE = 4        //默认最大行数
    var TEXT_CONTRACT = "收起"
    var TEXT_EXPEND = "展开"

    var retryTime = 0

    var mPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)

    //计算的layout
    lateinit var mDynamicLayout: DynamicLayout

    //hide状态下，展示多少行才开始省略
    var mLimitLines = 0

    var currentLines = 0

    var mWidth = 0

    //点击展开或者收回按钮时候，是否真的执行操作
    var needRealExpandOrContract = true

    //展开或者回收事件监听
    lateinit var expandOrContractClickListener: OnExpandOrContractClickListener;

    //是否需要展开功能
    var mNeedExpand = true

    init {

    }

}

interface OnExpandOrContractClickListener {
    fun onClick()
}