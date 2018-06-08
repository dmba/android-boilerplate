package me.dmba.mychecks.domain

import android.support.annotation.UiThread
import me.dmba.mychecks.data.model.Check

/**
 * Created by dmba on 6/8/18.
 */
interface DetailsContract {

    interface View {

        @UiThread
        fun showCheckItem(check: Check)

    }

    interface Presenter {

        @UiThread
        fun loadCheckItem(id: String)

    }

}
