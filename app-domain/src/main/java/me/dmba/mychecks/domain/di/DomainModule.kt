package me.dmba.mychecks.domain.di

import dagger.Binds
import dagger.Module
import me.dmba.mychecks.common.scopes.ForFragment
import me.dmba.mychecks.domain.DetailsContract
import me.dmba.mychecks.domain.MainContract
import me.dmba.mychecks.domain.presenters.DetailsPresenter
import me.dmba.mychecks.domain.presenters.MainPresenter

/**
 * Created by dmba on 6/5/18.
 */
@Module(
    includes = [
        DevDomainModule::class,
        DomainModuleBindings::class
    ]
)
object DomainModule

@Module
internal interface DomainModuleBindings {

    @Binds
    @ForFragment
    fun bindsMainPresenter(presenter: MainPresenter): MainContract.Presenter

    @Binds
    @ForFragment
    fun bindsDetailsPresenter(presenter: DetailsPresenter): DetailsContract.Presenter

}
