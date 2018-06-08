package me.dmba.mychecks.domain

import android.support.annotation.UiThread
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.domain.utils.BasePresenter

/**
 * Created by dmba on 6/8/18.
 */
interface DetailsContract {

    interface View {

        @UiThread
        fun showCheckItem(check: Check)

    }

    interface Presenter : BasePresenter {

        @UiThread
        fun loadCheckItem(id: String)

    }

}
