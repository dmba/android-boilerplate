package io.github.dmba.android_boilerplate.ui.di

import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.github.dmba.android_boilerplate.common.scopes.ForApplication
import io.github.dmba.android_boilerplate.ui.App

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
