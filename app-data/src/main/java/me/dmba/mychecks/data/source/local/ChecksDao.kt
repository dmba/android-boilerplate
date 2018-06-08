package me.dmba.mychecks.data.source.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import io.reactivex.Maybe
import me.dmba.mychecks.data.model.CheckObject
import me.dmba.mychecks.data.utils.BaseDao

/**
 * Created by dmba on 6/6/18.
 */
@Dao
internal interface ChecksDao : BaseDao<CheckObject> {

    @Query("SELECT * FROM Checks")
    fun getAll(): Flowable<List<CheckObject>>

    @Query("SELECT * FROM Checks WHERE id = :checkId")
    fun getById(checkId: String): Maybe<CheckObject>

    @Query("DELETE FROM Checks")
    fun deleteAll()

}
