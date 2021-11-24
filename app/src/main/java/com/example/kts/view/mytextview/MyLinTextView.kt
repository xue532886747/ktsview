package com.example.kts.view.mytextview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.kts.R

/**
 * @author 53288
 * @description
 * @date 2021/11/22
 */
class MyLinTextView(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet) {

    lateinit var text: String

    init {
        val ty = context.obtainStyledAttributes(attributeSet, R.styleable.my_textview)
        text = ty.getString(R.styleable.my_textview_textcontent).toString()
        ty.recycle()
        val inflate = LayoutInflater.from(context).inflate(R.layout.item_text, this)

    }


}