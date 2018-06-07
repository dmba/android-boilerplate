package me.dmba.mychecks.ui.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.dmba.mychecks.common.scopes.ForActivity
import me.dmba.mychecks.ui.screens.detail.DetailActivity
import me.dmba.mychecks.ui.screens.main.MainActivity

/**
 * Created by dmba on 6/4/18.
 */
@Module
interface ActivityBuilderModule {

    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class
        ]
    )
    @ForActivity
    fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(
        modules = [
            DetailActivityModule::class
        ]
    )
    @ForActivity
    fun contributeDetailActivity(): DetailActivity

}
