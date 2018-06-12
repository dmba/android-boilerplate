package me.dmba.mychecks.data.model

/**
 * Created by dmba on 6/12/18.
 */
sealed class ChecksStatus {

    class Ok : ChecksStatus()

    class DataFetchError(val throwable: Throwable) : ChecksStatus()

}
