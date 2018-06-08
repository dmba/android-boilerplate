package me.dmba.mychecks.common.rx

import io.reactivex.Scheduler

/**
 * Created by dmba on 6/8/18.
 */
interface AppSchedulers {

    val mainThread: Scheduler

    val background: Scheduler

}
