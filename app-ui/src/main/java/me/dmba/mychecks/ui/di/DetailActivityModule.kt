package me.dmba.mychecks.ui.di

import android.content.Context
import dagger.Binds
import dagger.Module
import me.dmba.mychecks.common.scopes.ForActivity
import me.dmba.mychecks.ui.screens.detail.DetailActivity

/**
 * Created by dmba on 6/4/18.
 */

@Module(
    includes = [
        DetailActivityBindingsModule::class
    ]
)
object DetailActivityModule

@Module
interface DetailActivityBindingsModule {

    @Binds
    @ForActivity
    fun bindsContext(activity: DetailActivity): Context

}
