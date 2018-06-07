package me.dmba.mychecks.data.source.local

import android.arch.persistence.room.*
import io.reactivex.Flowable
import io.reactivex.Maybe
import me.dmba.mychecks.data.model.CheckObject

/**
 * Created by dmba on 6/6/18.
 */
@Dao
internal interface ChecksDao {

    @Query("SELECT * FROM Checks")
    fun getAll(): Flowable<List<CheckObject>>

    @Query("SELECT * FROM Checks WHERE id = :checkId")
    fun getById(checkId: String): Maybe<CheckObject>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(checkObject: CheckObject): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(checkObject: List<CheckObject>): List<Long>

    @Delete
    fun delete(checkObject: CheckObject): Int

}
