package me.dmba.mychecks.domain.di

import dagger.Binds
import dagger.Module
import me.dmba.mychecks.common.scopes.ForActivity
import me.dmba.mychecks.domain.DevMenuContract
import me.dmba.mychecks.domain.presenters.DevMenuPresenter

/**
 * Created by dmba on 6/8/18.
 */
@Module(
    includes = [
        DevDomainModuleBindings::class
    ]
)
internal object DevDomainModule

@Module
internal interface DevDomainModuleBindings {

    @Binds
    @ForActivity
    fun bindsDevMenuPresenter(presenter: DevMenuPresenter): DevMenuContract.Presenter

}
