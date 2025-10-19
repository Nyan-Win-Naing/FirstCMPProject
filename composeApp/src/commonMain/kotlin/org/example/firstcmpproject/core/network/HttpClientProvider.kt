package org.example.firstcmpproject.core.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.firstcmpproject.core.utils.URL
import kotlin.time.Duration.Companion.seconds

object HttpClientProvider {
    val httpClient by lazy {
        // Object
        HttpClient {
            // Json Serialization
            install(ContentNegotiation) {
                // Configuration
                json(
                    Json {
                        ignoreUnknownKeys = true
                        explicitNulls = false
                        prettyPrint = true
                    }
                )
            }

            install(DefaultRequest) {
                url(URL)

                header(HttpHeaders.Accept, ContentType.Application.Json)
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }

            /// Time Out
            install(HttpTimeout) {
                connectTimeoutMillis = 30.seconds.inWholeMilliseconds
                socketTimeoutMillis = 30.seconds.inWholeMilliseconds
                requestTimeoutMillis = 30.seconds.inWholeMilliseconds
            }
        }
    }
}