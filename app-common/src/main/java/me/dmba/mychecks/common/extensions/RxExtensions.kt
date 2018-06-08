package me.dmba.mychecks.common.extensions

import io.reactivex.Flowable
import me.dmba.mychecks.common.rx.AppSchedulers

/**
 * Created by dmba on 6/8/18.
 */

fun <T> Flowable<T>.with(schedulers: AppSchedulers): Flowable<T> {
    return subscribeOn(schedulers.background).observeOn(schedulers.mainThread)
}
