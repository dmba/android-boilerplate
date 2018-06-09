package me.dmba.mychecks.data.source.local.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by dmba on 6/9/18.
 */
@Entity(tableName = "CheckItems")
internal data class CheckItemObject(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "checkId")
    var checkId: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "amount")
    var amount: String

)
