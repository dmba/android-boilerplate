package me.dmba.mychecks.data.di

import dagger.Module
import dagger.Provides
import io.reactivex.Flowable
import me.dmba.mychecks.common.scopes.ForApplication
import me.dmba.mychecks.data.source.remote.ChecksApi
import me.dmba.mychecks.data.source.remote.model.CheckListResponse

/**
 * Created by dmba on 6/8/18.
 */
@Module
internal object DevDataModule {

    @Provides
    @JvmStatic
    @ForApplication
    internal fun provideChecksApi(): ChecksApi = object : ChecksApi {
        override fun getAll(): Flowable<CheckListResponse> {
            //TODO
            return Flowable.empty()
        }
    }

}
