package me.dmba.mychecks.domain.utils

import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by dmba on 6/8/18.
 */
abstract class RxPresenter : BasePresenter {

    protected var subscriptions = CompositeDisposable()

    @CallSuper
    override fun onDestroy() {
        subscriptions.dispose()
    }

}
