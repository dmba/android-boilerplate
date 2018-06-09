package me.dmba.mychecks.data.source.local

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import me.dmba.mychecks.data.ChecksDataContract.LocalDataSource
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.data.source.local.model.mapCheckItemToObjectItem
import me.dmba.mychecks.data.source.local.model.mapCheckToObject
import me.dmba.mychecks.data.source.local.model.mapObjectWithItemsToCheck
import javax.inject.Inject

/**
 * Created by dmba on 6/5/18.
 */
internal class LocalChecksDataSource @Inject constructor(
    private val checksDao: ChecksDao,
    private val itemssDao: CheckItemsDao
) : LocalDataSource {

    override fun getChecks(refresh: Boolean): Flowable<List<Check>> {
        return checksDao.getAll().map { it.map(::mapObjectWithItemsToCheck).toList() }
    }

    override fun getCheckById(id: String): Maybe<Check> {
        return checksDao.getById(id).map(::mapObjectWithItemsToCheck)
    }

    override fun saveChecks(checks: List<Check>): Completable {
        return Completable.fromCallable {
            checks.forEach(::insertCheck)
        }
    }

    override fun clearAll(): Completable {
        return Completable.fromCallable(checksDao::deleteAll)
    }

    private fun insertCheck(check: Check) {
        check.let(::mapCheckToObject).also(checksDao::insert)
        check.items.map { mapCheckItemToObjectItem(check, it) }.also(itemssDao::insert)
    }

}
