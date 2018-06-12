package me.dmba.mychecks.data.di

import javax.inject.Qualifier

/**
 * Created by dmba on 6/12/18.
 */

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class KeyValueSession

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class KeyValuePrefs
