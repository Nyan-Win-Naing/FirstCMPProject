package org.example.firstcmpproject.movies.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.firstcmpproject.movies.data.MovieRepository
import org.example.firstcmpproject.movies.home.state.HomeState

class HomeViewModel : ViewModel() {
    val movieRepository = MovieRepository

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    private val _navigateToDetailSharedFlow: MutableSharedFlow<Long> = MutableSharedFlow()
    val navigateToDetailsSharedFlow = _navigateToDetailSharedFlow.asSharedFlow()

    init {
        // Featured Movies
        viewModelScope.launch {
//            val featuredMovie = movieRepository.getNowPlayingMovies().firstOrNull()
            val featuredMovie = movieRepository.getFeaturedMovie()
            _state.update {
                it.copy(
                    featuredMovie = featuredMovie
                )
            }
        }

        viewModelScope.launch {
            val moviesByGenre = movieRepository.getMoviesWithFirstFiveGenres()

            _state.update {
                it.copy(moviesByGenre = moviesByGenre)
            }
        }
    }

    fun onTapMovie(movieId: Long) {
        viewModelScope.launch {
            _navigateToDetailSharedFlow.emit(movieId)
        }
    }
}