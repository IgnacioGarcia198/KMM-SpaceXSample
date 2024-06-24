package com.garcia.ignacio.sqldelighttest

import com.garcia.ignacio.sqldelighttest.cache.Database
import com.garcia.ignacio.sqldelighttest.cache.DatabaseDriverFactory
import com.garcia.ignacio.sqldelighttest.entity.RocketLaunch
import com.garcia.ignacio.sqldelighttest.network.SpaceXApi

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory, val api: SpaceXApi) {
    private val database = Database(databaseDriverFactory)

    @Throws(Exception::class)
    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearAndCreateLaunches(it)
            }
        }
    }
}