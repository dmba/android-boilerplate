package me.dmba.mychecks.domain.di

import dagger.Module

/**
 * Created by dmba on 6/8/18.
 */
@Module(
    includes = [
        DevDomainModuleBindings::class
    ]
)
internal object DevDomainModule

@Module
internal interface DevDomainModuleBindings
