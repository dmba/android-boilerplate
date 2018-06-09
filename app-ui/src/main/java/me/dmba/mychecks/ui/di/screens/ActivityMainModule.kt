package me.dmba.mychecks.ui.di.screens

import android.content.Context
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import dagger.Binds
import dagger.Module
import dagger.Provides
import me.dmba.mychecks.common.scopes.ForActivity
import me.dmba.mychecks.domain.MainContract
import me.dmba.mychecks.ui.screens.MainActivity
import me.dmba.mychecks.ui.screens.MainNavigator

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

    @Provides
    @JvmStatic
    @ForActivity
    fun provideFragmentManager(activity: MainActivity): FragmentManager = activity.supportFragmentManager

}

@Module
interface MainActivityBindingsModule {

    @Binds
    @ForActivity
    fun bindsContext(activity: MainActivity): Context

    @Binds
    @ForActivity
    fun bindsNavigator(navigator: MainNavigator): MainContract.Navigator

}
