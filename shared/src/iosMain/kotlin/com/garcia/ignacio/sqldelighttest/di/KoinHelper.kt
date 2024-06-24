package com.garcia.ignacio.sqldelighttest.di

import com.garcia.ignacio.sqldelighttest.SpaceXSDK
import com.garcia.ignacio.sqldelighttest.entity.RocketLaunch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class KoinHelper : KoinComponent {
    private val sdk: SpaceXSDK by inject<SpaceXSDK>()

    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        return sdk.getLaunches(forceReload = forceReload)
    }
}