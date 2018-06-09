package me.dmba.mychecks.ui.di.screens

import dagger.Binds
import dagger.Module
import me.dmba.mychecks.common.scopes.ForFragment
import me.dmba.mychecks.domain.DetailsContract
import me.dmba.mychecks.ui.screens.detail.DetailsFragment

/**
 * Created by dmba on 6/9/18.
 */
@Module(
    includes = [
        DetailsFragmentBindingsModule::class
    ]
)
object DetailsFragmentModule

@Module
interface DetailsFragmentBindingsModule {

    @Binds
    @ForFragment
    fun bindsDetailsView(activity: DetailsFragment): DetailsContract.View

}
