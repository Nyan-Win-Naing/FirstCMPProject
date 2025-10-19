package org.example.firstcmpproject.movies.data.vos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductionCountryVO(
    @SerialName("iso_3166_1")
    val iso: String,

    @SerialName("name")
    val name: String,
)