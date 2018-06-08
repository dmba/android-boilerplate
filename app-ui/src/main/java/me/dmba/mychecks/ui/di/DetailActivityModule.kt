package me.dmba.mychecks.ui.di

import android.content.Context
import android.view.LayoutInflater
import dagger.Binds
import dagger.Module
import dagger.Provides
import me.dmba.mychecks.common.scopes.ForActivity
import me.dmba.mychecks.domain.DetailsContract
import me.dmba.mychecks.ui.screens.detail.DetailActivity

/**
 * Created by dmba on 6/4/18.
 */

@Module(
    includes = [
        DetailActivityBindingsModule::class
    ]
)
object DetailActivityModule {

    @Provides
    @JvmStatic
    @ForActivity
    fun provideLayoutInflater(activity: DetailActivity): LayoutInflater = activity.layoutInflater

}

@Module
interface DetailActivityBindingsModule {

    @Binds
    @ForActivity
    fun bindsContext(activity: DetailActivity): Context

    @Binds
    @ForActivity
    fun bindsDetailsView(activity: DetailActivity): DetailsContract.View

}
