package me.dmba.mychecks.data.di

import android.arch.persistence.room.Room
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import me.dmba.mychecks.common.scopes.ForApplication
import me.dmba.mychecks.data.ChecksDataContract
import me.dmba.mychecks.data.ChecksDataContract.LocalDataSource
import me.dmba.mychecks.data.ChecksDataContract.RemoteDataSource
import me.dmba.mychecks.data.source.ChecksRepo
import me.dmba.mychecks.data.source.local.*
import me.dmba.mychecks.data.source.remote.RemoteChecksDataSource

/**
 * Created by dmba on 6/4/18.
 */
@Module(
    includes = [
        DevDataModule::class,
        DataModuleBindings::class
    ]
)
object DataModule {

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

    @Provides
    @JvmStatic
    @ForApplication
    internal fun provideCheckItemsDao(database: ChecksDatabase): CheckItemsDao {
        return database.checkItemsDao()
    }

    @Provides
    @JvmStatic
    @ForApplication
    internal fun provideAppSharedPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.applicationInfo.packageName, MODE_PRIVATE)
    }

    @Provides
    @JvmStatic
    @ForApplication
    internal fun provideGson(): Gson {
        return GsonBuilder().create()
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

}
