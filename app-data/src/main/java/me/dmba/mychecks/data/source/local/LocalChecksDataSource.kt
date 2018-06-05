package me.dmba.mychecks.data.source.local

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import me.dmba.mychecks.data.ChecksDataContract.LocalDataSource
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.data.model.mapCheckToObject
import me.dmba.mychecks.data.model.mapObjectToCheck
import javax.inject.Inject

/**
 * Created by dmba on 6/5/18.
 */
internal class LocalChecksDataSource @Inject constructor(
    private val dao: ChecksDao
) : LocalDataSource {

    override fun getChecks(refresh: Boolean): Flowable<List<Check>> {
        return dao.getAll().map { it.map(::mapObjectToCheck).toList() }
    }

    override fun getCheckAt(id: String): Maybe<Check> {
        return dao.getById(id).map(::mapObjectToCheck)
    }

    override fun saveChecks(checks: List<Check>): Completable {
        return Completable.fromCallable {
            checks.map(::mapCheckToObject).forEach { dao.insert(it) }
        }
    }

    override fun clearAll(): Completable {
        //TODO
        return Completable.complete()
    }

}
