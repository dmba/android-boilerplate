package me.dmba.mychecks.ui.di

import android.content.Context
import com.squareup.picasso.Picasso
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.schedulers.Schedulers.io
import me.dmba.mychecks.common.rx.AppSchedulers
import me.dmba.mychecks.common.scopes.ForApplication
import me.dmba.mychecks.ui.App

/**
 * Created by dmba on 6/5/18.
 */

@Module(
    includes = [
        DevUiModule::class,
        AppBindingsModule::class
    ]
)
object AppModule {

    @Provides
    @JvmStatic
    @ForApplication
    fun providePicasso(context: Context): Picasso = Picasso.with(context)

    @Provides
    @JvmStatic
    @ForApplication
    fun provideAppSchedulers(): AppSchedulers = object : AppSchedulers {
        override val mainThread: Scheduler = mainThread()
        override val background: Scheduler = io()
    }

}

@Module
interface AppBindingsModule {

    @Binds
    @ForApplication
    fun bindsContext(app: App): Context

}
