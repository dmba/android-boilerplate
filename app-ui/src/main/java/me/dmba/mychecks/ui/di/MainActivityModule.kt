package me.dmba.mychecks.ui.di

import android.content.Context
import android.view.LayoutInflater
import dagger.Binds
import dagger.Module
import dagger.Provides
import me.dmba.mychecks.common.scopes.ForActivity
import me.dmba.mychecks.domain.main.MainContract
import me.dmba.mychecks.ui.screens.main.MainActivity
import me.dmba.mychecks.ui.screens.main.MainNavigator

/**
 * Created by dmba on 6/4/18.
 */

@Module(
    includes = [
        MainActivityBindingsModule::class
    ]
)
object MainActivityModule {

    @Provides
    @JvmStatic
    @ForActivity
    fun provideLayoutInflater(activity: MainActivity): LayoutInflater = activity.layoutInflater

}

@Module
interface MainActivityBindingsModule {

    @Binds
    @ForActivity
    fun bindsContext(activity: MainActivity): Context

    @Binds
    @ForActivity
    fun bindsMainView(activity: MainActivity): MainContract.View

    @Binds
    @ForActivity
    fun bindsNavigator(navigator: MainNavigator): MainContract.Navigator

}
