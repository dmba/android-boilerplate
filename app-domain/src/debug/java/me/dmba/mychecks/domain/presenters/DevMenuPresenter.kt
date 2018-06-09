package me.dmba.mychecks.domain.presenters

import me.dmba.mychecks.common.extensions.addTo
import me.dmba.mychecks.common.extensions.with
import me.dmba.mychecks.common.rx.AppSchedulers
import me.dmba.mychecks.data.devsettings.DevSettings
import me.dmba.mychecks.data.devsettings.DevSettingsProvider
import me.dmba.mychecks.domain.DevMenuContract
import me.dmba.mychecks.domain.utils.RxPresenter
import javax.inject.Inject

/**
 * Created by dmba on 6/9/18.
 */
internal class DevMenuPresenter @Inject constructor(
    private val view: DevMenuContract.View,
    private val schedulers: AppSchedulers,
    private val settings: DevSettingsProvider
) : RxPresenter(), DevMenuContract.Presenter {

    override fun loadData() {
        settings.model
            .with(schedulers)
            .subscribe(::onNext)
            .addTo(subscriptions)

        view.showStethoState(settings.stethoEnabled)
    }

    override fun onStethoStateChange(enabled: Boolean) {
        settings.stethoEnabled = enabled
    }

    private fun onNext(model: DevSettings) {
        view.showBuildInfo(model)
    }

}
