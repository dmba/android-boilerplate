package me.dmba.mychecks.domain

import android.support.annotation.UiThread
import me.dmba.mychecks.data.devsettings.DevSettings
import me.dmba.mychecks.domain.utils.BasePresenter

/**
 * Created by dmba on 6/9/18.
 */
interface DevMenuContract {

    interface View {

        @UiThread
        fun showBuildInfo(model: DevSettings)

        @UiThread
        fun showStethoState(enabled: Boolean)

    }

    interface Presenter : BasePresenter {

        @UiThread
        fun loadData()

        @UiThread
        fun onStethoStateChange(enabled: Boolean)

    }

}
