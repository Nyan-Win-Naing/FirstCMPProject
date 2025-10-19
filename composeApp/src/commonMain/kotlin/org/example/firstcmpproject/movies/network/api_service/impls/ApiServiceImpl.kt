package org.example.firstcmpproject.movies.network.api_service.impls

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpHeaders
import io.ktor.serialization.JsonConvertException
import org.example.firstcmpproject.core.network.HttpClientProvider
import org.example.firstcmpproject.core.network.NetflixError
import org.example.firstcmpproject.core.network.transformResult
import org.example.firstcmpproject.core.utils.API_KEY
import org.example.firstcmpproject.core.utils.GET_GENRES
import org.example.firstcmpproject.core.utils.GET_MOVIES_BY_GENRE
import org.example.firstcmpproject.core.utils.GET_MOVIES_DETAILS
import org.example.firstcmpproject.core.utils.NOW_PLAYING_MOVIES
import org.example.firstcmpproject.movies.data.vos.MovieVO
import org.example.firstcmpproject.movies.network.api_service.ApiService
import org.example.firstcmpproject.movies.network.responses.GenreListResponse
import org.example.firstcmpproject.movies.network.responses.MovieListResponse

object ApiServiceImpl : ApiService {
    override suspend fun getNowPlayingMovies(page: Int): MovieListResponse? {
        val httpResponse = HttpClientProvider.httpClient.get("$NOW_PLAYING_MOVIES?page=$page") {
            header(HttpHeaders.Authorization, "Bearer $API_KEY")
        }

//        return httpResponse.body<MovieListResponse?>()

        return transformResult<MovieListResponse?>(httpResponse)
    }

    override suspend fun getGenres(): GenreListResponse? {
        val httpResponse = HttpClientProvider.httpClient.get(GET_GENRES) {
            header(HttpHeaders.Authorization, "Bearer $API_KEY")
        }

        return transformResult<GenreListResponse?>(httpResponse)
    }

    override suspend fun getMoviesByGenre(genreId: Int): MovieListResponse? {
        val httpResponse =
            HttpClientProvider.httpClient.get("$GET_MOVIES_BY_GENRE?with_genres=$genreId") {
                header(HttpHeaders.Authorization, "Bearer $API_KEY")
            }

        return transformResult<MovieListResponse?>(httpResponse);
    }

    override suspend fun getMovieDetails(movieId: Long): MovieVO? {
        val httpResponse = HttpClientProvider.httpClient.get("$GET_MOVIES_DETAILS/$movieId") {
            header(HttpHeaders.Authorization, "Bearer $API_KEY")
        }

        return transformResult<MovieVO?>(httpResponse);
    }

}