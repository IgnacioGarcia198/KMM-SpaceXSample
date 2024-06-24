package com.garcia.ignacio.sqldelighttest.di

import com.garcia.ignacio.sqldelighttest.SpaceXSDK
import com.garcia.ignacio.sqldelighttest.cache.IOSDatabaseDriverFactory
import com.garcia.ignacio.sqldelighttest.network.SpaceXApi
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin() {
    startKoin {
        modules(module {
            single<SpaceXApi> { SpaceXApi() }
            single<SpaceXSDK> {
                SpaceXSDK(
                    databaseDriverFactory = IOSDatabaseDriverFactory(), api = get()
                )
            }
        })
    }
}