package me.dmba.mychecks.domain.di

import dagger.Module

/**
 * Created by dmba on 6/8/18.
 */
@Module(
    includes = [
        DevUiModuleBindings::class
    ]
)
internal object DevUiModule

@Module
internal interface DevUiModuleBindings
