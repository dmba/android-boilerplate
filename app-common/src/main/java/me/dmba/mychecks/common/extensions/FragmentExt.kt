package me.dmba.mychecks.common.extensions

import android.support.v4.app.Fragment

/**
 * Created by dmba on 6/9/18.
 */

fun <T : Any> Fragment.arg(key: String) = lazy {
    return@lazy arguments.get(key) as? T ?: error("Illegal type for $key")
}
