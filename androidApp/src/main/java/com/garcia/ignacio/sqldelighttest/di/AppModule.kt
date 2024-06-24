package com.garcia.ignacio.sqldelighttest.di

import com.garcia.ignacio.sqldelighttest.SpaceXSDK
import com.garcia.ignacio.sqldelighttest.android.RocketLaunchViewModel
import com.garcia.ignacio.sqldelighttest.cache.AndroidDatabaseDriverFactory
import com.garcia.ignacio.sqldelighttest.network.SpaceXApi
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<SpaceXApi> { SpaceXApi() }
    single<SpaceXSDK> {
        SpaceXSDK(
            databaseDriverFactory = AndroidDatabaseDriverFactory(
                androidContext()
            ), api = get()
        )
    }
    viewModel { RocketLaunchViewModel(sdk = get()) }
}