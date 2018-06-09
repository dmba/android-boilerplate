package me.dmba.mychecks.data.source.remote

import io.reactivex.Flowable
import me.dmba.mychecks.data.source.remote.model.CheckListResponse

/**
 * Created by dmba on 6/6/18.
 */
internal interface ChecksApi {

    fun getAll(): Flowable<CheckListResponse>

}
