package me.dmba.mychecks.common.extensions

import io.reactivex.Flowable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.DisposableContainer
import me.dmba.mychecks.common.rx.AppSchedulers

/**
 * Created by dmba on 6/8/18.
 */
operator fun DisposableContainer.plusAssign(disposable: Disposable) {
    add(disposable)
}

fun <T> Flowable<T>.with(schedulers: AppSchedulers): Flowable<T> {
    return subscribeOn(schedulers.background).observeOn(schedulers.mainThread)
}

fun Disposable.addTo(disposables: DisposableContainer): Disposable {
    disposables += this
    return this
}
