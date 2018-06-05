package me.dmba.mychecks.data.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import me.dmba.mychecks.common.scopes.ForApplication
import me.dmba.mychecks.data.ChecksDataSource
import me.dmba.mychecks.data.LocalChecksDataSource

/**
 * Created by dmba on 6/4/18.
 */
@Module(
    includes = [
        DataModuleBindings::class
    ]
)
object DataModule {

    @Provides
    @JvmStatic
    @ForApplication
    fun provideAppSharedPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.applicationInfo.packageName, MODE_PRIVATE)
    }

}

@Module
interface DataModuleBindings {

    @Binds
    @ForApplication
    fun bindsLocalDataSource(dataSource: LocalChecksDataSource): ChecksDataSource

}
