package org.example.firstcmpproject.movies.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MARGIN_MEDIUM_2
import org.example.firstcmpproject.movies.home.state.HomeState
import org.example.firstcmpproject.movies.home.viewmodel.HomeViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeRoute(
    viewModel: HomeViewModel,
    onTapMovie: (Long) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.navigateToDetailsSharedFlow.collectLatest {
            onTapMovie(it)
        }
    }

    HomeScreen(
        state = state,
        onTapMovie = {
            viewModel.onTapMovie(it)
        }
    )
}

@Composable
fun HomeScreen(state: HomeState, onTapMovie: (Long) -> Unit) {
    Scaffold(
        topBar = {
            HomeAppBar()
        },
        containerColor = Color.Black,
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            item {
                /// Movie Category
                MovieCategorySection(modifier = Modifier.padding(start = MARGIN_MEDIUM_2))
            }


            item {
                // Featured Movie
                if (state.featuredMovie != null) {
                    FeaturedMovie(
                        movie = state.featuredMovie,
                        modifier = Modifier.clickable {
                            onTapMovie(state.featuredMovie.id);
                        },
                    )
                }

            }

            // Space
            item {
                Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
            }

            items(count = state.moviesByGenre.count()) { index ->
                GenreNameAndMovies(
                    genre = state.moviesByGenre[index].first,
                    movieList = state.moviesByGenre[index].second,
                    onTapMovie = {
                        onTapMovie(it)
                    },
                )
            }
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(state = HomeState(), onTapMovie = {})
}