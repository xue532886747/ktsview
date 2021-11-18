package com.example.kts.utils

import android.content.res.Resources
import android.util.TypedValue

/**
 * @author 53288
 * @description
 * @date 2021/11/16
 */

val Float.px
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )

val Int.dp
    get() = this.toFloat().px