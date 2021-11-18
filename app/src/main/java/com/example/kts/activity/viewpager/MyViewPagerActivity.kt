package com.example.kts.activity.viewpager


import android.util.Log
import com.example.kts.activity.viewpager.adapter.ImageAdapter
import com.example.kts.base.BaseActivity


import android.view.LayoutInflater
import android.view.View
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.kts.R
import com.example.kts.databinding.MyViewpagerBinding


/**
 * @author 53288
 * @description
 * @date 2021/11/16
 */
class MyViewPagerActivity : BaseActivity<MyViewpagerBinding>() {
    private var mutableList: MutableList<Int> = ArrayList()
    val TAG: String = "MyViewPagerActivity1"
    override fun initView() {
        mutableList.add(R.mipmap.hello)
        mutableList.add(R.mipmap.ic_launcher_round)
        mutableList.add(R.mipmap.weixin)
        mutableList.add(R.mipmap.ic_launcher)
        mutableList.add(R.mipmap.shoucang)
        mBind.viewPager.adapter = ImageAdapter(this, mutableList)
        mBind.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                Log.d(TAG, "onPageScrolled position = $position")
            }

            override fun onPageSelected(position: Int) {
                Log.d(TAG, "onPageSelected position = $position")
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
        mBind.viewPager.setPageTransformer(true, ScalePageTransformer())
    }

    override fun getLayout(): Int {
        return R.layout.my_viewpager
    }
}