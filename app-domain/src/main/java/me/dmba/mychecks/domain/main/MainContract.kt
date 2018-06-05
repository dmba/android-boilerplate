package me.dmba.mychecks.domain.main

import android.support.annotation.UiThread
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.domain.BasePresenter

/**
 * Created by dmba on 6/3/18.
 */
interface MainContract {

    interface View {

        @UiThread
        fun updateList(items: List<Check>)

    }

    interface Presenter : BasePresenter {

        @UiThread
        fun onItemSelect(check: Check, itemPosition: Int)

        @UiThread
        fun loadData()

    }

    interface Navigator {

        @UiThread
        fun goToDetails(check: Check, itemPosition: Int)

    }

}
