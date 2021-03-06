package me.dmba.mychecks.domain.presenters

import me.dmba.mychecks.common.extensions.addTo
import me.dmba.mychecks.common.extensions.with
import me.dmba.mychecks.common.rx.AppSchedulers
import me.dmba.mychecks.data.ChecksDataContract.Repo
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.data.model.ChecksStatus
import me.dmba.mychecks.data.model.ChecksStatus.DataFetchError
import me.dmba.mychecks.data.model.ChecksStatus.Ok
import me.dmba.mychecks.domain.MainContract
import me.dmba.mychecks.domain.MainContract.Navigator
import me.dmba.mychecks.domain.MainContract.View
import me.dmba.mychecks.domain.utils.RxPresenter
import javax.inject.Inject

/**
 * Created by dmba on 6/3/18.
 */
internal class MainPresenter @Inject constructor(
    private val repo: Repo,
    private val view: View,
    private val navigator: Navigator,
    private val schedulers: AppSchedulers
) : RxPresenter(), MainContract.Presenter {

    init {
        repo.getChecksStatus()
            .with(schedulers)
            .subscribe(::onStatusChange)
            .addTo(subscriptions)
    }

    override fun loadData(refresh: Boolean) {
        view.showLoading()
        repo.getChecks(refresh)
            .with(schedulers)
            .subscribe(::onNext)
            .addTo(subscriptions)
    }

    override fun onItemSelect(check: Check, itemPosition: Int) {
        navigator.goToDetails(check, itemPosition)
    }

    private fun onNext(items: List<Check>) {
        view.updateList(items)
        view.hideLoading()
    }

    private fun onStatusChange(status: ChecksStatus) {
        when (status) {
            is DataFetchError -> view.showDataFetchError()
            is Ok -> view.hideAllErrors()
        }
        view.hideLoading()
    }

}
