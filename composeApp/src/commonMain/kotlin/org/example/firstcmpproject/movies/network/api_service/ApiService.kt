package org.example.firstcmpproject.movies.network.api_service

import org.example.firstcmpproject.movies.data.vos.MovieVO
import org.example.firstcmpproject.movies.network.responses.GenreListResponse
import org.example.firstcmpproject.movies.network.responses.MovieListResponse

interface ApiService {
    suspend fun getNowPlayingMovies(page: Int): MovieListResponse?
    suspend fun getGenres(): GenreListResponse?

    suspend fun getMoviesByGenre(genreId: Int): MovieListResponse?

    suspend fun getMovieDetails(movieId: Long): MovieVO?
}