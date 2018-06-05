package me.dmba.mychecks.data

import android.support.annotation.AnyThread
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import me.dmba.mychecks.data.model.Check

/**
 * Created by dmba on 6/5/18.
 */
interface ChecksDataContract {

    interface BaseDataSource {

        @AnyThread
        fun getChecks(refresh: Boolean = false): Flowable<List<Check>>

    }

    interface LocalDataSource : BaseDataSource {

        @AnyThread
        fun getCheckAt(id: String): Maybe<Check>

        @AnyThread
        fun saveChecks(checks: List<Check>): Completable

        @AnyThread
        fun clearAll(): Completable

    }

    interface RemoteDataSource : BaseDataSource

    interface Repo : RemoteDataSource, LocalDataSource

}
