package com.example.kts.activity.viewpager;

import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * @author 53288
 * @description
 * @date 2021/11/17
 */
public class ScalePageTransformer implements ViewPager.PageTransformer {

    public static final float MAX_SCALE = 2.0f;
    public static final float MIN_SCALE = 0.6f;
    private static final String TAG = "ScalePageTransformer1";

    /**
     * 核心就是实现transformPage(View page, float position)这个方法
     **/
    @Override
    public void transformPage(View page, float position) {
        Log.d(TAG, "page = " + page);
        if (position < -1) {
            position = -1;
        } else if (position > 1) {
            position = 1;
        }

        float tempScale = position < 0 ? 1 + position : 1 - position;

        float slope = (MAX_SCALE - MIN_SCALE) / 1;
        //一个公式
        float scaleValue = MIN_SCALE + tempScale * slope;
        page.setScaleX(scaleValue);
        page.setScaleY(scaleValue);

    }
}
