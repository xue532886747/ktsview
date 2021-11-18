package com.example.kts.activity.viewpager.adapter

import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.media.Image
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide


import android.view.LayoutInflater
import com.example.kts.R


/**
 * @author 53288
 * @description
 * @date 2021/11/16
 */
class ImageAdapter(var context: Context, var mViewList: MutableList<Int>) : PagerAdapter() {

    override fun getCount(): Int {
        return mViewList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_base, container, false)
        val imageView = view.findViewById(R.id.iv_image) as ImageView
        Glide.with(context).load(mViewList[position]).into(imageView)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    override fun getPageWidth(position: Int): Float {
        return 1.0f / 3
    }
}