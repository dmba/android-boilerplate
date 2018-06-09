package me.dmba.mychecks.data

/**
 * Created by dmba on 6/9/18.
 */
interface KeyValue {

    fun put(key: String, value: Any)

    fun getString(key: String, defaultValue: String = ""): String

    fun getBool(key: String, defaultValue: Boolean = false): Boolean

    fun getInt(key: String, defaultValue: Int = -1): Int

    fun getLong(key: String, defaultValue: Long = -1): Long

    fun getFloat(key: String, defaultValue: Float = -1F): Float

}
