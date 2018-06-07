package me.dmba.mychecks.domain

import android.support.annotation.UiThread
import me.dmba.mychecks.data.model.Check

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

    interface Presenter {

        @UiThread
        fun onItemSelect(check: Check, itemPosition: Int)

        @UiThread
        fun loadData(refresh: Boolean = false)

    }

    interface Navigator {

        @UiThread
        fun goToDetails(check: Check, itemPosition: Int)

    }

}
