package me.dmba.mychecks.data.source.local.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation


/**
 * Created by dmba on 6/9/18.
 */
internal data class CheckWithItems(

    @Embedded
    var check: CheckObject

) {

    @Relation(
        parentColumn = "id",
        entityColumn = "checkId"
    )
    lateinit var items: List<CheckItemObject>

}
