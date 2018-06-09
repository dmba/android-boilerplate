package me.dmba.mychecks.data.di

import android.content.Context
import android.content.res.AssetManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import me.dmba.mychecks.common.scopes.ForApplication
import me.dmba.mychecks.data.source.remote.ChecksApi
import me.dmba.mychecks.data.source.remote.DevChecksApi

/**
 * Created by dmba on 6/8/18.
 */
@Module(
    includes = [
        DevDataModuleBindings::class
    ]
)
internal object DevDataModule {

    @Provides
    @JvmStatic
    @ForApplication
    internal fun provideAssetManager(context: Context): AssetManager {
        return context.resources.assets
    }

}

@Module
internal interface DevDataModuleBindings {

    @Binds
    @ForApplication
    fun bindsChecksApi(api: DevChecksApi): ChecksApi

}
