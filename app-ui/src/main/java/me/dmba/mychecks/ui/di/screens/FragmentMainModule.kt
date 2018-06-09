package me.dmba.mychecks.ui.di.screens

import dagger.Binds
import dagger.Module
import me.dmba.mychecks.common.scopes.ForFragment
import me.dmba.mychecks.domain.MainContract
import me.dmba.mychecks.ui.screens.main.MainFragment

/**
 * Created by dmba on 6/10/18.
 */
@Module(
    includes = [
        FragmentMainModuleBindings::class
    ]
)
object FragmentMainModule

@Module
interface FragmentMainModuleBindings {

    @Binds
    @ForFragment
    fun bindsMainView(activity: MainFragment): MainContract.View

}
