package me.dmba.mychecks.domain.di

import dagger.Binds
import dagger.Module
import me.dmba.mychecks.common.scopes.ForActivity
import me.dmba.mychecks.domain.main.MainContract
import me.dmba.mychecks.domain.main.MainPresenter

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
interface DomainModuleBindings {

    @Binds
    @ForActivity
    fun bindsMainPresenter(presenter: MainPresenter): MainContract.Presenter

}
