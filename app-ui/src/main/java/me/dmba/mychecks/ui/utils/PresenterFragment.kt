package me.dmba.mychecks.ui.utils

import dagger.android.support.DaggerFragment
import me.dmba.mychecks.domain.utils.BasePresenter

/**
 * Created by dmba on 6/9/18.
 */
abstract class PresenterFragment<T : BasePresenter> : DaggerFragment() {

    abstract val presenter: T

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDestroy()
    }

}
