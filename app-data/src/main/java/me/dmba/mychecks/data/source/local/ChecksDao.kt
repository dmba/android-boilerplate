package me.dmba.mychecks.data.source.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import io.reactivex.Flowable
import io.reactivex.Maybe
import me.dmba.mychecks.data.source.local.model.CheckObject
import me.dmba.mychecks.data.source.local.model.CheckWithItems
import me.dmba.mychecks.data.utils.BaseDao

/**
 * Created by dmba on 6/6/18.
 */
@Dao
internal interface ChecksDao : BaseDao<CheckObject> {

    @Transaction
    @Query("SELECT * FROM Checks")
    fun getAll(): Flowable<List<CheckWithItems>>

    @Transaction
    @Query("SELECT * FROM Checks WHERE id = :checkId")
    fun getById(checkId: String): Maybe<CheckWithItems>

    @Query("DELETE FROM Checks")
    fun deleteAll()

}
