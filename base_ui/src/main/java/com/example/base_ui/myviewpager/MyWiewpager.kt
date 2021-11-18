package com.example.base_ui.myviewpager

import android.R
import android.content.Context
import android.media.effect.Effect
import android.util.AttributeSet
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.view.animation.Interpolator
import android.widget.EdgeEffect
import android.widget.Scroller
import androidx.core.view.iterator


/**
 * @author 53288
 * @description
 * @date 2021/11/17
 */
class MyWiewpager(context: Context, attributeSet: AttributeSet) : ViewGroup(context, attributeSet) {

    private val DEFAULT_OFFSCREEN_PAGES = 1
    private val MAX_SETTLE_DURATION = 600
    private val MIN_DISTANCE_FOR_FLING = 25 // dips
    private val DEFAULT_GUTTER_SIZE = 16 // dips
    private val MIN_FLING_VELOCITY = 400 // dips

    private var mTouchSlop: Int = 0

    //Determines speed during touch scrolling
    private var mMinimumVelocity = 0
    private var mMaximumVelocity = 0

    private lateinit var mLeftEdge: EdgeEffect
    private lateinit var mRightEdge: EdgeEffect

    val LAYOUT_ATTRS = intArrayOf(
        R.attr.layout_gravity
    )

    val sInterpolator: Interpolator by lazy {
        Interpolator { t ->
            var t1 = t;
            t1 = -1f
            t1 * t1 * t1 * t1 * t1 + 1.0f
        }
    }

    lateinit var mScroller: Scroller

    interface OnPageChangeListener {
        fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int)
        fun onPageSelected(position: Int)
        fun onPageScrollStateChanged(state: Int)
    }

    inner class SimpleOnPageChangeListener : OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {

        }

        override fun onPageSelected(position: Int) {

        }

        override fun onPageScrollStateChanged(state: Int) {

        }

    }

    //Callback interface for responding to adapter changes.
    interface OnAdapterChangeListener {
        fun onAdapterChanged(
            myViewPager: MyWiewpager,
            oldAdapter: MyWiewpager,
            newAdapter: MyWiewpager
        )
    }

    init {
        initViewPager();
    }

    private fun initViewPager() {
        setWillNotDraw(false)       //查一查
        descendantFocusability = FOCUS_AFTER_DESCENDANTS    //查一查
        isFocusable = true          //查一查
        mScroller = Scroller(context, sInterpolator)
        val configuration: ViewConfiguration = ViewConfiguration.get(context)
        val density = context.resources.displayMetrics.density
        mTouchSlop = configuration.scaledPagingTouchSlop
        mLeftEdge = EdgeEffect(context)
        mRightEdge = EdgeEffect(context)


    }

    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {

    }
}