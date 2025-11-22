package org.example.firstcmpproject.movies.detail.actions

sealed class DetailActions {

    class OnTapMovie(val movieId: Long): DetailActions()

    class OnTapBack(): DetailActions()
}