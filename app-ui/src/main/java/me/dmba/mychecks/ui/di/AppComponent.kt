package me.dmba.mychecks.ui.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import me.dmba.mychecks.common.scopes.ForApplication
import me.dmba.mychecks.data.di.DataModule
import me.dmba.mychecks.domain.di.DomainModule
import me.dmba.mychecks.ui.App
import me.dmba.mychecks.ui.di.screens.ActivityBuilderModule

/**
 * Created by dmba on 5/28/18.
 */
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        DataModule::class,
        DomainModule::class,
        ActivityBuilderModule::class
    ]
)
@ForApplication
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun app(app: App): Builder

        fun build(): AppComponent

    }

}
