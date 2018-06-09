package me.dmba.mychecks.data.keyvalue

import me.dmba.mychecks.data.KeyValue
import javax.inject.Inject

/**
 * Created by dmba on 6/9/18.
 */
internal class SessionKeyValue @Inject constructor() : KeyValue {

    private val map: MutableMap<String, Any> = mutableMapOf()

    override fun put(key: String, value: Any) {
        map[key] = value
    }

    override fun getString(key: String, defaultValue: String): String {
        return map.getOrDefault(key, defaultValue) as String
    }

    override fun getBool(key: String, defaultValue: Boolean): Boolean {
        return map.getOrDefault(key, defaultValue) as Boolean
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        return map.getOrDefault(key, defaultValue) as Int
    }

    override fun getLong(key: String, defaultValue: Long): Long {
        return map.getOrDefault(key, defaultValue) as Long
    }

    override fun getFloat(key: String, defaultValue: Float): Float {
        return map.getOrDefault(key, defaultValue) as Float
    }

}
