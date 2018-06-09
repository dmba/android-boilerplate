package me.dmba.mychecks.ui.di

import dagger.Binds
import dagger.Module
import me.dmba.mychecks.common.scopes.ForActivity
import me.dmba.mychecks.ui.utils.NoOpViewModifier
import me.dmba.mychecks.ui.utils.ViewModifier

/**
 * Created by dmba on 6/8/18.
 */
@Module(
    includes = [
        DevUiModuleBindings::class
    ]
)
internal object DevUiModule

@Module
internal interface DevUiModuleBindings {

    @Binds
    @ForActivity
    fun bindViewModifier(modifier: NoOpViewModifier): ViewModifier

}
