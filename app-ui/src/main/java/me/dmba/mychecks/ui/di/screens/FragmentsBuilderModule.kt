package me.dmba.mychecks.ui.di.screens

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.dmba.mychecks.common.scopes.ForFragment
import me.dmba.mychecks.ui.screens.detail.DetailsFragment

/**
 * Created by dmba on 6/9/18.
 */
@Module
interface FragmentsBuilderModule {

    @ContributesAndroidInjector(
        modules = [
            DetailsFragmentModule::class
        ]
    )
    @ForFragment
    fun contributeDetailsFragment(): DetailsFragment

}
