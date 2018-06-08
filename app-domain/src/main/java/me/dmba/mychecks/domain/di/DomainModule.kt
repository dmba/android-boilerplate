package me.dmba.mychecks.domain.di

import dagger.Binds
import dagger.Module
import me.dmba.mychecks.common.scopes.ForActivity
import me.dmba.mychecks.domain.DetailsContract
import me.dmba.mychecks.domain.MainContract
import me.dmba.mychecks.domain.presenters.DetailsPresenter
import me.dmba.mychecks.domain.presenters.MainPresenter

/**
 * Created by dmba on 6/5/18.
 */
@Module(
    includes = [
        DomainModuleBindings::class
    ]
)
object DomainModule

@Module
internal interface DomainModuleBindings {

    @Binds
    @ForActivity
    fun bindsMainPresenter(presenter: MainPresenter): MainContract.Presenter

    @Binds
    @ForActivity
    fun bindsDetailsPresenter(presenter: DetailsPresenter): DetailsContract.Presenter

}
