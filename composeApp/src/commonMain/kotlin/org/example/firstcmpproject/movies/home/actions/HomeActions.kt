package org.example.firstcmpproject.movies.home.actions

sealed class HomeActions {
    class OnTapMovie(val movieId: Long) : HomeActions()
}