package io.github.dmba.android_boilerplate.ui

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.github.dmba.android_boilerplate.ui.di.AppComponent
import io.github.dmba.android_boilerplate.ui.di.DaggerAppComponent

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
