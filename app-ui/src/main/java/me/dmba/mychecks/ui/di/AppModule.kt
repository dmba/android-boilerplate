package me.dmba.mychecks.ui.di

import android.content.Context
import com.squareup.picasso.Picasso
import dagger.Binds
import dagger.Module
import dagger.Provides
import me.dmba.mychecks.common.scopes.ForApplication
import me.dmba.mychecks.ui.App

/**
 * Created by dmba on 6/5/18.
 */

@Module(
    includes = [
        AppBindingsModule::class
    ]
)
object AppModule {

    @Provides
    @JvmStatic
    @ForApplication
    fun providePicasso(context: Context): Picasso = Picasso.with(context)

}

@Module
interface AppBindingsModule {

    @Binds
    @ForApplication
    fun bindsContext(app: App): Context

}
