package org.example.firstcmpproject.movies.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.firstcmpproject.movies.data.vos.DateVO
import org.example.firstcmpproject.movies.data.vos.MovieVO

@Serializable
data class MovieListResponse(
    @SerialName("dates")
    val dates: DateVO? = null,

    @SerialName("page")
    val page: Int,

    @SerialName("results")
    val results: List<MovieVO>
)