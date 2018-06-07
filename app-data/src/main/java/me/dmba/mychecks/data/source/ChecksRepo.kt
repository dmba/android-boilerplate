package me.dmba.mychecks.data.source

import io.reactivex.Flowable
import me.dmba.mychecks.data.ChecksDataContract.*
import me.dmba.mychecks.data.model.Check
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

    private var firstLoad = true;

    private val fetchAndSaveRemoteChecks: Flowable<List<Check>> by lazy {
        remote.getChecks()
            .doOnNext {
                saveChecks(it).subscribe()
            }
            .doOnComplete {
                firstLoad = false
            }
    }

    override fun getChecks(refresh: Boolean): Flowable<List<Check>> {
        return if (refresh || firstLoad) {
            Flowable.concat(fetchAndSaveRemoteChecks, local.getChecks())
        } else {
            local.getChecks()
        }
    }

}
