package me.dmba.mychecks.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by dmba on 6/6/18.
 */
@Entity(tableName = "Checks")
internal data class CheckObject(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "amount")
    var amount: String,

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "imgUrl")
    var imgUrl: String,

    @ColumnInfo(name = "isReceived")
    var isReceived: Boolean

)
