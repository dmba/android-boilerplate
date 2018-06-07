package me.dmba.mychecks.domain.presenters

import me.dmba.mychecks.common.extensions.with
import me.dmba.mychecks.common.rx.AppSchedulers
import me.dmba.mychecks.data.ChecksDataContract.Repo
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.domain.MainContract
import me.dmba.mychecks.domain.MainContract.Navigator
import me.dmba.mychecks.domain.MainContract.View
import java.io.IOException
import javax.inject.Inject

/**
 * Created by dmba on 6/3/18.
 */
internal class MainPresenter @Inject constructor(
    private val repo: Repo,
    private val view: View,
    private val navigator: Navigator,
    private val schedulers: AppSchedulers
) : MainContract.Presenter {

    override fun loadData(refresh: Boolean) {
        view.showLoading()
        repo.getChecks(refresh)
            .with(schedulers)
            .subscribe(::onNext, ::onError)
    }

    override fun onItemSelect(check: Check, itemPosition: Int) {
        navigator.goToDetails(check, itemPosition)
    }

    private fun onNext(items: List<Check>) {
        view.updateList(items)
        view.hideLoading()
    }

    private fun onError(throwable: Throwable) {
        when (throwable) {
            is IOException -> view.showDataFetchError()
            else -> view.showDataFetchError()
        }
        view.hideLoading()
    }

}
