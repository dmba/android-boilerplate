package me.dmba.mychecks.domain.main

import me.dmba.mychecks.data.ChecksDataSource
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.domain.main.MainContract.Navigator
import me.dmba.mychecks.domain.main.MainContract.View
import javax.inject.Inject

/**
 * Created by dmba on 6/3/18.
 */
class MainPresenter @Inject constructor(
    private val view: View,
    private val navigator: Navigator,
    private val dataSource: ChecksDataSource
) : MainContract.Presenter {

    private val data: List<Check> by lazy { dataSource.getChecks() }

    override fun loadData() {
        view.updateList(data)
    }

    override fun onItemSelect(check: Check, itemPosition: Int) {
        navigator.goToDetails(check, itemPosition)
    }

}
