package me.dmba.mychecks.common.extensions

import android.app.Activity
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import java.util.*

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

fun Activity.snack(@StringRes messageRes: Int, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
    snack(resources.getString(messageRes), length, f)
}

fun Activity.snack(message: String, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
    val snack = Snackbar.make(find(android.R.id.content), message, length)
    snack.f()
    snack.show()
}

fun <T : Any> Activity.extra(key: String) = lazy {
    return@lazy intent.extras[key] as? T ?: error("Illegal type for $key")
}

fun <T : Fragment> AppCompatActivity.findFragmentById(@IdRes fragmentId: Int): T {
    return supportFragmentManager.findFragmentById(fragmentId) as T
}

fun <T : Fragment> AppCompatActivity.findFragmentByTag(tag: String): T {
    return supportFragmentManager.findFragmentByTag(tag) as T
}

fun ClosedRange<Int>.random(): Long = (Random().nextInt(endInclusive - start) + start).toLong()
