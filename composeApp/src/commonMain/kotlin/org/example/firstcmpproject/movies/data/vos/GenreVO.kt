package org.example.firstcmpproject.movies.data.vos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenreVO(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,
)