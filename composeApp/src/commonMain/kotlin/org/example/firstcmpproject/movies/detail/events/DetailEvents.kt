package org.example.firstcmpproject.movies.detail.events

sealed class DetailEvents {
    class NavigateToDetails(val movieId: Long): DetailEvents()

    class NavigateToBack(): DetailEvents()
}