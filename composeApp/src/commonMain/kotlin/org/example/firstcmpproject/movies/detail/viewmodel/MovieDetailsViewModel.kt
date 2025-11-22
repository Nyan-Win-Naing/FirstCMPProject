package org.example.firstcmpproject.movies.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.firstcmpproject.movies.data.MovieRepository
import org.example.firstcmpproject.movies.detail.actions.DetailActions
import org.example.firstcmpproject.movies.detail.events.DetailEvents
import org.example.firstcmpproject.movies.detail.state.MovieDetailsState

class MovieDetailsViewModel(val movieId: Long) : ViewModel() {

    // Repository
    private val movieRepository = MovieRepository

    /// State
    private val _state = MutableStateFlow(MovieDetailsState())
    val state = _state.asStateFlow()

    //    private val _navigateToDetailSharedFlow: MutableSharedFlow<Long> = MutableSharedFlow()
//    val navigateToDetailsSharedFlow = _navigateToDetailSharedFlow.asSharedFlow()
//
//    private val _navigateBackHomeSharedFlow: MutableSharedFlow<Boolean> = MutableSharedFlow()
//    val navigateBackHomeSharedFlow = _navigateBackHomeSharedFlow.asSharedFlow()
    private val _navigationSharedFlow: MutableSharedFlow<DetailEvents> = MutableSharedFlow()
    val navigationSharedFlow = _navigationSharedFlow.asSharedFlow()

    init {
        // Network
        viewModelScope.launch {
            val movieDetails = movieRepository.getMovieDetail(movieId)
            _state.update {
                it.copy(movieDetails = movieDetails)
            }

            movieDetails?.genres?.firstOrNull()?.id?.let { genreId ->
                val similarMovies = movieRepository.getMoviesByGenre(genreId).toMutableList()

                similarMovies.removeAll { it.id == movieId }
                _state.update { it.copy(similarMovies = similarMovies) }
            }
        }

        viewModelScope.launch {
            val movieDetails = movieRepository.getMovieDetailsFromDb(movieId)

            println("Current movie details =====> $movieDetails")
            _state.update {
                it.copy(movieDetails = movieDetails)
            }
        }
    }

//    fun onTapMovie(movieId: Long) {
//        viewModelScope.launch {
//            _navigateToDetailSharedFlow.emit(movieId)
//        }
//    }
//
//    fun onTapBack() {
//        viewModelScope.launch {
//            _navigateBackHomeSharedFlow.emit(true)
//        }
//    }

    fun onAction(action: DetailActions) {
        when (action) {
            is DetailActions.OnTapMovie -> {
                viewModelScope.launch {
                    _navigationSharedFlow.emit(DetailEvents.NavigateToDetails(action.movieId))
                }
            }

            is DetailActions.OnTapBack -> {
                viewModelScope.launch {
                    _navigationSharedFlow.emit(DetailEvents.NavigateToBack())
                }
            }
        }
    }
}