package me.dmba.mychecks.ui

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import me.dmba.mychecks.ui.di.AppComponent
import me.dmba.mychecks.ui.di.DaggerAppComponent

/**
 * Created by dmba on 5/29/18.
 */
class App : DaggerApplication() {

    private val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .app(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = component

}
