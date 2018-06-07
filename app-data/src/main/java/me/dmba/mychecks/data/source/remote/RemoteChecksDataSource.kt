package me.dmba.mychecks.data.source.remote

import io.reactivex.Flowable
import me.dmba.mychecks.data.ChecksDataContract.RemoteDataSource
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.data.model.mapResponseToCheck
import javax.inject.Inject

/**
 * Created by dmba on 6/5/18.
 */
internal class RemoteChecksDataSource @Inject constructor(
    private val api: ChecksApi
) : RemoteDataSource {

    override fun getChecks(refresh: Boolean): Flowable<List<Check>> {
        return api.getAll()
            .flatMapIterable { it.checks }
            .map(::mapResponseToCheck)
            .toList()
            .toFlowable()
    }

}
