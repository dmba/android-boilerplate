package me.dmba.mychecks.data.source

import android.util.Log
import io.reactivex.Flowable
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

    override fun getChecks(refresh: Boolean): Flowable<List<Check>> {
        return Flowable.concatArrayEager(
            local.getChecks(),
            remote.getChecks()
                .materialize()
                .doOnNext { it.error?.let(::handleErrorCallback) }
                .filter { !it.isOnError }
                .dematerialize<List<Check>>()
                .doOnNext { saveChecks(it).subscribe() }
                .debounce(400, MILLISECONDS)
        )
    }

    private fun handleErrorCallback(error: Throwable) {
        Log.e("REPO", "Error occurred $error")
    }

}
