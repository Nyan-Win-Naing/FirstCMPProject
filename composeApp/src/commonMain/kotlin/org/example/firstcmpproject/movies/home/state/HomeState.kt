package org.example.firstcmpproject.movies.home.state

import org.example.firstcmpproject.movies.data.vos.GenreVO
import org.example.firstcmpproject.movies.data.vos.MovieVO

data class HomeState(
    val featuredMovie: MovieVO? = null,
    val moviesByGenre: List<Pair<GenreVO, List<MovieVO>>> = listOf(),
    val isLoading: Boolean = false,
    val error: String = "",
)