package me.dmba.mychecks.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import me.dmba.mychecks.data.source.local.model.CheckItemObject
import me.dmba.mychecks.data.source.local.model.CheckObject

/**
 * Created by dmba on 6/6/18.
 */

const val CHECKS_DB_NAME = "ChecksDB"

@Database(
    version = 1,
    entities = [
        CheckObject::class,
        CheckItemObject::class
    ],
    exportSchema = false
)
internal abstract class ChecksDatabase : RoomDatabase() {

    abstract fun checksDao(): ChecksDao

    abstract fun checkItemsDao(): CheckItemsDao

}
