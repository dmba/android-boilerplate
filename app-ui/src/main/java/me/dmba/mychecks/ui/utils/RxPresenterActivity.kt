package me.dmba.mychecks.ui.utils

import dagger.android.support.DaggerAppCompatActivity
import me.dmba.mychecks.domain.utils.BasePresenter

/**
 * Created by dmba on 6/8/18.
 */
abstract class RxPresenterActivity<T : BasePresenter> : DaggerAppCompatActivity() {

    abstract val presenter: T

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}
