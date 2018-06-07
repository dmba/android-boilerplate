package me.dmba.mychecks.data.utils

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update

/**
 * Created by dmba on 7/5/18.
 */
internal interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg obj: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(list: List<T>)

    @Update
    fun update(obj: T)

    @Delete
    fun delete(obj: T)

    @Delete
    fun delete(vararg obj: T)

    @Delete
    fun delete(list: List<T>)

}
