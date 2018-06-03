package me.dmba.mychecks.common.extensions

import android.app.Activity
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.view.View
import android.widget.Toast

/**
 * Created by dmba on 6/3/18.
 */

inline fun <reified T : View> Activity.find(@IdRes id: Int): T = findViewById(id)

fun Activity.toast(message: String, lenght: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, lenght).show()
}

fun Activity.toast(@StringRes messageRes: Int, lenght: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, messageRes, lenght).show()
}

fun <T : Any> Activity.extra(key: String) = lazy {
    return@lazy intent.extras[key] as? T ?: error("Illegal type for $key")
}
