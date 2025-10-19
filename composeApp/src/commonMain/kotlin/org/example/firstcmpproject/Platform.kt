package org.example.firstcmpproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform