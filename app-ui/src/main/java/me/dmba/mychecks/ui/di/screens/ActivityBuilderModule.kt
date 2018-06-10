package me.dmba.mychecks.ui.di.screens

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.dmba.mychecks.common.scopes.ForActivity
import me.dmba.mychecks.ui.screens.MainActivity

/**
 * Created by dmba on 6/4/18.
 */
@Module
interface ActivityBuilderModule {

    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            FragmentBuilderModule::class
        ]
    )
    @ForActivity
    fun contributeMainActivity(): MainActivity

}
