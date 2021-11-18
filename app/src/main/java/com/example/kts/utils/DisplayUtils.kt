package com.example.kts.utils

import android.content.res.Resources
import android.util.TypedValue
import java.lang.reflect.Type

/**
 * @author 53288
 * @description
 * @date 2021/11/16
 */
object DisplayUtils {
    fun dp2px(_dp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            _dp,
            Resources.getSystem().displayMetrics
        )
    }

    fun px2dp(_dp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_PX,
            _dp,
            Resources.getSystem().displayMetrics
        )
    }
}