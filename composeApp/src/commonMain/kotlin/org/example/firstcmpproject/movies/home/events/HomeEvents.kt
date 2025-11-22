package org.example.firstcmpproject.movies.home.events

sealed class HomeEvents {
    class NavigateToDetails(val movieId: Long): HomeEvents()
}