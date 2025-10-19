package org.example.firstcmpproject.movies.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.firstcmpproject.movies.data.vos.GenreVO

@Serializable
data class GenreListResponse(
    @SerialName("genres")
    val genres: List<GenreVO>
)