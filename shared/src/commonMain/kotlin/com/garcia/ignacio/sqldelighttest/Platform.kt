package com.garcia.ignacio.sqldelighttest

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform