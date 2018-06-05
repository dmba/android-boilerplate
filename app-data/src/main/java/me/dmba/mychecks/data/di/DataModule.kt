package me.dmba.mychecks.data.di

import android.arch.persistence.room.Room
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import me.dmba.mychecks.common.scopes.ForApplication
import me.dmba.mychecks.data.ChecksDataContract
import me.dmba.mychecks.data.ChecksDataContract.LocalDataSource
import me.dmba.mychecks.data.ChecksDataContract.RemoteDataSource
import me.dmba.mychecks.data.source.ChecksRepo
import me.dmba.mychecks.data.source.local.CHECKS_DB_NAME
import me.dmba.mychecks.data.source.local.ChecksDao
import me.dmba.mychecks.data.source.local.ChecksDatabase
import me.dmba.mychecks.data.source.local.LocalChecksDataSource
import me.dmba.mychecks.data.source.remote.ChecksApi
import me.dmba.mychecks.data.source.remote.FakeChecksApi
import me.dmba.mychecks.data.source.remote.RemoteChecksDataSource

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
    internal fun provideAppSharedPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.applicationInfo.packageName, MODE_PRIVATE)
    }

    @Provides
    @JvmStatic
    @ForApplication
    internal fun provideChecksDatabase(context: Context): ChecksDatabase {
        return Room.databaseBuilder(context, ChecksDatabase::class.java, CHECKS_DB_NAME)
            .build()
    }

    @Provides
    @JvmStatic
    @ForApplication
    internal fun provideChecksDao(database: ChecksDatabase): ChecksDao {
        return database.checksDao()
    }

}

@Module
internal interface DataModuleBindings {

    @Binds
    @ForApplication
    fun bindsLocalDataSource(dataSource: LocalChecksDataSource): LocalDataSource

    @Binds
    @ForApplication
    fun bindsRemoteDataSource(dataSource: RemoteChecksDataSource): RemoteDataSource

    @Binds
    @ForApplication
    fun bindsRepo(repo: ChecksRepo): ChecksDataContract.Repo

    @Binds
    @ForApplication
    fun bindsChecksApi(api: FakeChecksApi): ChecksApi

}
