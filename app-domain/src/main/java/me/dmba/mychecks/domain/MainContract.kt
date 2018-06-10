package me.dmba.mychecks.domain

import android.support.annotation.UiThread
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.domain.utils.BasePresenter

/**
 * Created by dmba on 6/3/18.
 */
interface MainContract {

    interface View {

        @UiThread
        fun updateList(items: List<Check>)

        @UiThread
        fun showLoading()

        @UiThread
        fun hideLoading()

        @UiThread
        fun showDataFetchError()

    }

    interface Presenter : BasePresenter {

        @UiThread
        fun onItemSelect(check: Check, itemPosition: Int)

        @UiThread
        fun loadData(refresh: Boolean = false)

    }

    interface Navigator {

        @UiThread
        fun goToMainScreen()

        @UiThread
        fun goToDetails(check: Check, itemPosition: Int)

    }

}
