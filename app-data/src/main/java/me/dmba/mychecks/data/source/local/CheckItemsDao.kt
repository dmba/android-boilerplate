package me.dmba.mychecks.data.source.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import io.reactivex.Maybe
import me.dmba.mychecks.data.source.local.model.CheckItemObject
import me.dmba.mychecks.data.utils.BaseDao

/**
 * Created by dmba on 6/9/18.
 */
@Dao
internal interface CheckItemsDao : BaseDao<CheckItemObject> {

    @Query("SELECT * FROM CheckItems")
    fun getAll(): Flowable<List<CheckItemObject>>

    @Query("SELECT * FROM CheckItems WHERE id = :checkItemId")
    fun getById(checkItemId: String): Maybe<CheckItemObject>

    @Query("DELETE FROM CheckItems")
    fun deleteAll()

}
