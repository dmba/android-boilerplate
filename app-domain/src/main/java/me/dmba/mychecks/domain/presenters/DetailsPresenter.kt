package me.dmba.mychecks.domain.presenters

import me.dmba.mychecks.common.extensions.addTo
import me.dmba.mychecks.common.extensions.with
import me.dmba.mychecks.common.rx.AppSchedulers
import me.dmba.mychecks.data.ChecksDataContract.Repo
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.domain.DetailsContract
import me.dmba.mychecks.domain.DetailsContract.View
import me.dmba.mychecks.domain.utils.RxPresenter
import javax.inject.Inject

/**
 * Created by dmba on 6/8/18.
 */
internal class DetailsPresenter @Inject constructor(
    private val view: View,
    private val repo: Repo,
    private val schedulers: AppSchedulers
) : RxPresenter(), DetailsContract.Presenter {

    override fun loadCheckItem(id: String) {
        repo.getCheckById(id)
            .with(schedulers)
            .subscribe(::onNext)
            .addTo(subscriptions)
    }

    private fun onNext(check: Check) {
        view.showCheckItem(check)
    }

}
