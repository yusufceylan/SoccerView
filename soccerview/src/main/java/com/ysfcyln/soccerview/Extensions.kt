package com.ysfcyln.soccerview

import android.content.res.Resources

/**
 * Convert px to dp
 */
val Int.ToDp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

/**
 * Convert dp to px
 */
val Int.ToPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()