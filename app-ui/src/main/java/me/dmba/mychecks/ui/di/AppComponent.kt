package me.dmba.mychecks.ui.di

import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import me.dmba.mychecks.common.scopes.ForApplication
import me.dmba.mychecks.ui.App

/**
 * Created by dmba on 5/28/18.
 */
@ForApplication
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun app(app: App): Builder

        fun build(): AppComponent

    }

}


@Module
object AppModule {

}
