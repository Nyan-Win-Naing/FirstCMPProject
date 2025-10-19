package org.example.firstcmpproject.movies.data.vos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductionCompanyVO(

    @SerialName("id")
    val id: Int,

    @SerialName("logo_path")
    val logoPath: String?,

    @SerialName("name")
    val name: String,

    @SerialName("origin_country")
    val originCountry: String,
)