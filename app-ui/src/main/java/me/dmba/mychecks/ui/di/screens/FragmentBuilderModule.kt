package me.dmba.mychecks.ui.di.screens

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.dmba.mychecks.common.scopes.ForFragment
import me.dmba.mychecks.ui.screens.details.DetailsFragment
import me.dmba.mychecks.ui.screens.main.MainFragment

/**
 * Created by dmba on 6/9/18.
 */
@Module
interface FragmentBuilderModule {

    @ContributesAndroidInjector(
        modules = [
            FragmentMainModule::class
        ]
    )
    @ForFragment
    fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector(
        modules = [
            FragmentDetailsModule::class
        ]
    )
    @ForFragment
    fun contributeDetailsFragment(): DetailsFragment

}
