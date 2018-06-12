package me.dmba.mychecks.data.source

import io.reactivex.BackpressureStrategy.BUFFER
import io.reactivex.Flowable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import me.dmba.mychecks.data.ChecksDataContract.*
import me.dmba.mychecks.data.model.Check
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

    private val errors: Subject<Throwable> = BehaviorSubject.create()

    override fun getErrors(): Flowable<Throwable> = errors.toFlowable(BUFFER)

    override fun getChecks(refresh: Boolean): Flowable<List<Check>> {
        return Flowable.concatArrayEager(
            local.getChecks(),
            remote.getChecks()
                .materialize()
                .doOnNext { it.error?.let(errors::onNext) }
                .filter { !it.isOnError }
                .dematerialize<List<Check>>()
                .doOnNext { saveChecks(it).subscribe() }
                .debounce(400, MILLISECONDS)
        )
    }

}
