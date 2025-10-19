package org.example.firstcmpproject.movies.data

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.example.firstcmpproject.core.persistence.AppDatabaseProvider
import org.example.firstcmpproject.movies.data.vos.GenreVO
import org.example.firstcmpproject.movies.data.vos.MovieVO
import org.example.firstcmpproject.movies.network.api_service.ApiService
import org.example.firstcmpproject.movies.network.api_service.impls.ApiServiceImpl

object MovieRepository {
    val apiService: ApiService = ApiServiceImpl

    val appDatabase = AppDatabaseProvider.appDatabase

    suspend fun getNowPlayingMovies(): List<MovieVO> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getNowPlayingMovies(1)

            launch {
                appDatabase.movieDao().insertMovies(response?.results ?: listOf())
                println("Movies from db ======> ${appDatabase.movieDao().getAllMovies()}")
            }


            return@withContext response?.results ?: listOf()
        }

    }

    suspend fun getFeaturedMovie(): MovieVO? {
        /// Get Now Playing Movies
        return withContext(Dispatchers.IO) {
            val nowPlayingMovies = getNowPlayingMovies()

            val firstMovieId = nowPlayingMovies.firstOrNull()?.id

            if (firstMovieId != null) {
                val movieDetail = getMovieDetail(firstMovieId)
                return@withContext movieDetail
            } else {
                return@withContext null
            }


//            val movieDetailDeferred = async {
//                val movieDetail = getMovieDetail(firstMovieId ?: -1L)
//                return@async movieDetail
//            }
//
//            movieDetailDeferred.await()
        }

        /// First

        /// Use id of the first movie -> Get Movie Details

        /// Return
    }

    suspend fun getMoviesWithFirstFiveGenres(): List<Pair<GenreVO, List<MovieVO>>> {
        return withContext(Dispatchers.IO) {
            val genres = getGenres()

            val moviesByGenreDeferredList: List<Deferred<Pair<GenreVO, List<MovieVO>>>> =
                genres.take(5).map { genre ->
                    async {
                        println("Genre ID is ===> ${genre.id}")
                        val moviesByGenre = getMoviesByGenre(genre.id)
                        return@async Pair(genre, moviesByGenre)
                    }
                }

            moviesByGenreDeferredList.awaitAll()
        }
    }

    suspend fun getGenres(): List<GenreVO> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getGenres();
            return@withContext response?.genres ?: listOf();
        }
    }

    suspend fun getMoviesByGenre(genreId: Int): List<MovieVO> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getMoviesByGenre(genreId)
            return@withContext response?.results ?: listOf()
        };
    }

    suspend fun getMovieDetail(movieId: Long): MovieVO? {
        return withContext(Dispatchers.IO) {
            val movieDetails = apiService.getMovieDetails(movieId)
            launch {
                movieDetails?.let {
                    appDatabase.movieDao().insertSingleMovie(movieDetails)
                }
            }
            return@withContext movieDetails
        }
    }

    suspend fun getMovieDetailsFromDb(movieId: Long): MovieVO? {
        return appDatabase.movieDao().getMovieById(movieId)
    }
}