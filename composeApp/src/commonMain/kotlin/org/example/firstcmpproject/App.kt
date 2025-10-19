package org.example.firstcmpproject

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import androidx.room.RoomDatabase

import kotlinx.serialization.Serializable
import org.example.firstcmpproject.auth.ui.NetflixLoginScreen
import org.example.firstcmpproject.core.NetflixSansTypography
import org.example.firstcmpproject.core.persistence.AppDatabase
import org.example.firstcmpproject.core.persistence.AppDatabaseProvider
import org.example.firstcmpproject.movies.data.MovieRepository
import org.example.firstcmpproject.movies.detail.ui.MovieDetailsRoute
import org.example.firstcmpproject.movies.detail.viewmodel.MovieDetailsViewModel
import org.example.firstcmpproject.movies.home.ui.HomeRoute
import org.example.firstcmpproject.movies.home.viewmodel.HomeViewModel

@Composable
fun App(
    databaseBuilder: RoomDatabase.Builder<AppDatabase>
) {

    AppDatabaseProvider.initializeDatabase(databaseBuilder)

    val navController = rememberNavController()

    LaunchedEffect(
        Unit
    ) {
//        val moviesGenres = MovieRepository.getMoviesWithFirstFiveGenres()
//        println("First five movies by genre ======> $moviesGenres")

        val movieDetail = MovieRepository.getFeaturedMovie();
        println("Movie Detail is ======> $movieDetail")
    }

//    LaunchedEffect(Unit) {
//        try {
//            val movies = ApiServiceImpl.getNowPlayingMovies(1)
//            println("Now Playing Movies =====> $movies")
//        } catch (e: Exception) {
//            println("Now playing movies error ====> ${e.message}")
//        }
//    }

//    LaunchedEffect(Unit) {
//        val genres = MovieRepository.getGenres()
//        println("Genres ========> $genres")
//
//        val moviesByGenre = MovieRepository.getMoviesByGenre(genreId = 28)
//        println("Movies by genre =====> $moviesByGenre")
//    }

    MaterialTheme(
        typography = NetflixSansTypography()
    ) {
        NavHost(
            navController = navController,
            startDestination = NavRoutes.Login,
//            startDestination = NavRoutes.MovieDetails(0)
        ) {
            /// Login Screen
            composable<NavRoutes.Login> {
                NetflixLoginScreen(
                    onTapSignIn = {
                        navController.navigate(NavRoutes.Home)
                    })
            }

            /// Home Screen
            composable<NavRoutes.Home> {

                val homeViewModel = viewModel { HomeViewModel() }
                HomeRoute(
                    viewModel = homeViewModel,
                    onTapMovie = {
                        navController.navigate(NavRoutes.MovieDetails(it))
                    },
                )
            }

            composable<NavRoutes.MovieDetails> { backstackEntry ->
                val args =  backstackEntry.toRoute<NavRoutes.MovieDetails>()
                val movieId = args.movieId

                val movieDetailViewModel = viewModel {
                    MovieDetailsViewModel(movieId = movieId)
                }

                MovieDetailsRoute(
                    viewModel = movieDetailViewModel,
                    onTapMovie = {
                        navController.navigate(NavRoutes.MovieDetails(it))
                    },
                    onTapBack = {
                        navController.navigateUp()
                    },
                )
            }
        }

    }
}

@Serializable
sealed class NavRoutes {
    @Serializable
    object Login

    @Serializable
    object Home

    @Serializable
    data class MovieDetails(val movieId: Long)
}