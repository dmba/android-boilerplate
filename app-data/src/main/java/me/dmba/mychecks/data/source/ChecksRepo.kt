package me.dmba.mychecks.data.source

import io.reactivex.BackpressureStrategy.BUFFER
import io.reactivex.Flowable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import me.dmba.mychecks.common.extensions.firewall
import me.dmba.mychecks.data.ChecksDataContract.*
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.data.model.ChecksStatus
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject

/**
 * Created by dmba on 6/5/18.
 */
internal class ChecksRepo @Inject constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource
) : Repo,
    LocalDataSource by local,
    RemoteDataSource by remote {

    private val status: Subject<ChecksStatus> = BehaviorSubject.create()

    override fun getChecksStatus(): Flowable<ChecksStatus> = status.toFlowable(BUFFER)

    override fun getChecks(refresh: Boolean): Flowable<List<Check>> {
        return Flowable.concatArrayEager(
            local.getChecks()
                .firewall(::handleDataFetchOk, ::handleDataFetchError),
            remote.getChecks()
                .firewall(::handleDataFetchOk, ::handleDataFetchError)
                .doOnNext { saveChecks(it).subscribe() }
                .debounce(400, MILLISECONDS)
        )
    }

    private fun handleDataFetchError(throwable: Throwable) {
        status.onNext(ChecksStatus.DataFetchError(throwable))
    }

    private fun handleDataFetchOk() {
        status.onNext(ChecksStatus.Ok())
    }

}
