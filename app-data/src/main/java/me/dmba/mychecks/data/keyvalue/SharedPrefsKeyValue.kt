package me.dmba.mychecks.data.keyvalue

import android.content.SharedPreferences
import me.dmba.mychecks.data.KeyValue
import javax.inject.Inject

/**
 * Created by dmba on 6/9/18.
 */
internal class SharedPrefsKeyValue @Inject constructor(
    private val prefs: SharedPreferences
) : KeyValue {

    override fun put(key: String, value: Any) {
        val editor = prefs.edit()

        when (value) {
            is Boolean -> editor.putBoolean(key, value)
            is String -> editor.putString(key, value)
            is Float -> editor.putFloat(key, value)
            is Long -> editor.putLong(key, value)
            is Int -> editor.putInt(key, value)
        }

        editor.apply()
    }

    override fun getString(key: String, defaultValue: String): String {
        return prefs.getString(key, defaultValue)
    }

    override fun getBool(key: String, defaultValue: Boolean): Boolean {
        return prefs.getBoolean(key, defaultValue)
    }

    override fun getFloat(key: String, defaultValue: Float): Float {
        return prefs.getFloat(key, defaultValue)
    }

    override fun getLong(key: String, defaultValue: Long): Long {
        return prefs.getLong(key, defaultValue)
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        return prefs.getInt(key, defaultValue)
    }

}
